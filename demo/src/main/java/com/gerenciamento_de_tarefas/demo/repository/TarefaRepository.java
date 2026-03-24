package com.gerenciamento_de_tarefas.demo.repository;

import com.gerenciamento_de_tarefas.demo.entity.Tarefa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TarefaRepository extends JpaRepository<Tarefa, Long> {
}