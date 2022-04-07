package com.mdt.bigdata;

import org.apache.commons.io.IOUtils;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FSDataInputStream;
import org.apache.hadoop.fs.FSDataOutputStream;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;

/**
 * Implementation of some Hdfs APIs.
 *
 * @author Mohammad Reza Dehghani
 */
public class HDFSExample {

    public static void main(String[] args) throws IOException {
        HDFSExample.checkExists();
//        HDFSExample.createDirectory();
//        HDFSExample.removeDirectory();
//        ReadWriteHDFSExample.checkExists();
        HDFSExample.writeFileToHDFS();
//        HDFSExample.removeFile();
//        HDFSExample.appendToHDFSFile();
        HDFSExample.readFileFromHDFS();

    }

    public static void readFileFromHDFS() throws IOException {
        Configuration configuration = new Configuration();
        configuration.set("fs.defaultFS", "hdfs://master:9000");
//        configuration.set("HADOOP_HOME", "/opt/hadoop-3.3.1");
        FileSystem fileSystem = FileSystem.get(configuration);
        //Create a path
        String fileName = "myFile.xml";
        Path hdfsReadPath = new Path("/user/" + fileName);
        //Init input stream
        FSDataInputStream inputStream = fileSystem.open(hdfsReadPath);
        //Classical input stream usage
        String out = IOUtils.toString(inputStream, "UTF-8");
        System.out.println(out);

        /*BufferedReader bufferedReader = new BufferedReader(
                new InputStreamReader(inputStream, StandardCharsets.UTF_8));

        String line = null;
        while ((line=bufferedReader.readLine())!=null){
            System.out.println(line);
        }*/

        inputStream.close();
        fileSystem.close();
    }

    public static void writeFileToHDFS() throws IOException {
        Configuration configuration = new Configuration();
        configuration.set("fs.defaultFS", "hdfs://master:9000");
        FileSystem fileSystem = FileSystem.get(configuration);
        //Create a path
        String fileName = "write_hdfs_example.txt";
        Path hdfsWritePath = new Path("/user/" + fileName);
        FSDataOutputStream fsDataOutputStream = fileSystem.create(hdfsWritePath, true);

        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(fsDataOutputStream, StandardCharsets.UTF_8));
        bufferedWriter.write("Java API to write data in HDFS");
        bufferedWriter.newLine();
        bufferedWriter.close();
        fileSystem.close();
    }

    public static void appendToHDFSFile() throws IOException {
        Configuration configuration = new Configuration();
        configuration.set("fs.defaultFS", "hdfs://master:9000");
        FileSystem fileSystem = FileSystem.get(configuration);
        //Create a path
        String fileName = "write_hdfs_example.txt";
        Path hdfsWritePath = new Path("/user/" + fileName);
        FSDataOutputStream fsDataOutputStream = fileSystem.append(hdfsWritePath);

        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(fsDataOutputStream, StandardCharsets.UTF_8));
        bufferedWriter.write("Java API to append data in HDFS file");
        bufferedWriter.newLine();
        bufferedWriter.close();
        fileSystem.close();
    }

    public static void createDirectory() throws IOException {
        Configuration configuration = new Configuration();
        configuration.set("fs.defaultFS", "hdfs://master:9000");
        FileSystem fileSystem = FileSystem.get(configuration);
        String directoryName = "/user/root/MDT";
        Path path = new Path(directoryName);
        fileSystem.mkdirs(path);
    }

    public static void removeDirectory() throws IOException {
        Configuration configuration = new Configuration();
        configuration.set("fs.defaultFS", "hdfs://master:9000");
        FileSystem fileSystem = FileSystem.get(configuration);
        String directoryName = "/user/root/MDT";
        Path path = new Path(directoryName);
        System.out.println("About to delete directory...");
        fileSystem.deleteOnExit(path);
    }

    public static void removeFile() throws IOException {
        Configuration configuration = new Configuration();
        configuration.set("fs.defaultFS", "hdfs://master:9000");
        FileSystem fileSystem = FileSystem.get(configuration);
        String fileName = "write_hdfs_example.txt";
        Path filePath = new Path("/user/" + fileName);
        System.out.println("About to delete file...");
        fileSystem.deleteOnExit(filePath);
    }

    public static void checkExists() throws IOException {
        Configuration configuration = new Configuration();
        configuration.set("fs.defaultFS", "hdfs://master:9000");
        FileSystem fileSystem = FileSystem.get(configuration);
        String directoryName = "/user/root/MDT";
        Path path = new Path(directoryName);
        if (fileSystem.exists(path)) {
            System.out.println("File/Folder Exists : " + path.getName());
        } else {
            System.out.println("File/Folder does not Exists : " + path.getName());
        }
    }
}
