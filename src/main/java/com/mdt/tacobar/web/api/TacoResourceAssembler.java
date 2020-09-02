package com.mdt.tacobar.web.api;

import com.mdt.tacobar.Taco;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;

import java.util.ArrayList;
import java.util.List;

public class TacoResourceAssembler extends RepresentationModelAssemblerSupport<Taco, TacoResource> {

    public TacoResourceAssembler() {
        super(RecentTacosController.class, TacoResource.class);
    }

    // I'm not sure this is true
    @Override
    public TacoResource instantiateModel(Taco taco) {
        return new TacoResource(taco);
    }

    // to create a TacoResource Object from a Taco and to automatically give it a self link with
    // the URL being derived from the Taco object's id property
    @Override
    public TacoResource toModel(Taco taco) {
        return createModelWithId(taco.getId(), taco);
    }

    public List<TacoResource> toModels(List<Taco> tacos) {
        ArrayList<TacoResource> tacoResourceList = new ArrayList<>();
        for (Taco t : tacos) {
            tacoResourceList.add(toModel(t));
        }
        return tacoResourceList;
    }
}
