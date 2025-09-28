package Tarea1_4._3;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;


public class Main {
    public static void main(String[] args) {


        try (BufferedReader br = Files.newBufferedReader(Path.of("pedidos.json"))) {

            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            Type tipoLista = new TypeToken<List<Pedido>>(){}.getType();

            List<Pedido> pedidos = gson.fromJson(br,tipoLista);


            double total = 0;
            Map<Estado,Integer> estados = new HashMap<>();
            for (Pedido pedido : pedidos){
                total += pedido.getImporte();
                estados.put(pedido.getEstado(),estados.getOrDefault(pedido.getEstado(),0)+1);

            }
            Pedido masCaro = pedidos.stream()
                    .max(Comparator.comparingDouble(Pedido::getImporte))
                    .orElse(null);


            Map<String, Object> informe = new HashMap<>();
            informe.put("totalImporte",total);
            informe.put("numPendientes", estados.get(Estado.PENDIENTE));
            informe.put("numEnviados", estados.get(Estado.ENVIADO));
            informe.put("numCancelados", estados.get(Estado.CANCELADO));

            Map<String, Object> pedidoCaro = new HashMap<>();
            pedidoCaro.put("id", masCaro.getId());
            pedidoCaro.put("cliente", masCaro.getCliente());
            pedidoCaro.put("importe", masCaro.getImporte());

            informe.put("pedidoMasCaro", pedidoCaro);

            try (BufferedWriter bw = Files.newBufferedWriter(Path.of("informes.json"))){
                gson.toJson(informe,bw);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }



    }
}
