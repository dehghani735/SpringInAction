package com.mdt.tacobar.web.api;

import com.mdt.tacobar.Taco;
import com.mdt.tacobar.data.TacoRepository;
import org.hibernate.EntityMode;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import java.util.List;

@RestController
public class RecentTacosController {

    private TacoRepository tacoRepo;

    public RecentTacosController(TacoRepository repo){
        this.tacoRepo = repo;
    }

    @GetMapping
    public CollectionModel<TacoResource> recentTacos() {
        PageRequest page = PageRequest.of(
                0, 12, Sort.by("createdAt").descending());
        List<Taco> tacos = tacoRepo.findAll(page).getContent();

        // the outputted json has element name "tacoResourceList", because it is derived from
        // List<TacoResource>
        List<TacoResource> tacoResources = new TacoResourceAssembler().toModels(tacos);

        CollectionModel<TacoResource> recentResources =
                new CollectionModel<TacoResource>(tacoResources);

        // add a link whose relationship name is recents
//        v1
//        recentResources.add(new Link("http://localhost:8080/design/recent", "recents"));
//        v2
//        recentResources.add(ControllerLinkBuilder.linkTo(DesignTacoController.class)
//                .slash("recent")
//                .withRel("recents"));

//        v3
        recentResources.add(
                linkTo(methodOn(RecentTacosController.class).recentTacos())
                .withRel("recents"));
        return recentResources;
    }
}
