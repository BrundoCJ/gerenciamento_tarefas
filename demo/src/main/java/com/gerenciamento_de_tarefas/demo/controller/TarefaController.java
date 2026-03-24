package com.gerenciamento_de_tarefas.demo.controller;

import com.gerenciamento_de_tarefas.demo.entity.Tarefa;
import com.gerenciamento_de_tarefas.demo.service.TarefaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/tarefas")
public class TarefaController {

    private final TarefaService tarefaService;

    public TarefaController(TarefaService tarefaService) {
        this.tarefaService = tarefaService;
    }

    @PostMapping
    public ResponseEntity<Tarefa> criarTarefa(@RequestBody Tarefa tarefa) {
        Tarefa tarefaSalva = tarefaService.salvar(tarefa);
        return ResponseEntity.status(HttpStatus.CREATED).body(tarefaSalva);
    }

    @GetMapping
    public ResponseEntity<List<Tarefa>> listarTarefas() {
        return ResponseEntity.ok(tarefaService.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Tarefa> buscarTarefaPorId(@PathVariable Long id) {
        Optional<Tarefa> tarefa = tarefaService.buscarPorId(id);
        return tarefa.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarTarefa(@PathVariable Long id) {
        boolean deletado = tarefaService.deletar(id);
        if (deletado) return ResponseEntity.noContent().build();
        return ResponseEntity.notFound().build();
    }
}