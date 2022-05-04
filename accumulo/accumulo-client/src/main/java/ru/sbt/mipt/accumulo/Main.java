package ru.sbt.mipt.accumulo;

import org.apache.accumulo.core.client.Accumulo;
import org.apache.accumulo.core.client.AccumuloClient;
import org.apache.accumulo.core.client.BatchWriter;
import org.apache.accumulo.core.data.Mutation;

public class Main {
    public static void main(String[] args) {
        AccumuloClient client = Accumulo.newClient()
                .from("C:\\Users\\George\\Desktop\\Projects\\Java\\mipt-db-2022\\accumulo\\accumulo-client\\src\\main\\resources\\accumulo.properties")
                .build();
        System.out.println(client);


        try (BatchWriter writer = client.createBatchWriter("mytable")) {
            Mutation m = new Mutation("row1");
            m.at().family("myfam").qualifier("myqual").visibility("public").put("myval");
            writer.addMutation(m);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
