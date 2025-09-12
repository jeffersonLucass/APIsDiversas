package io.github.jeffersonLucass.arquiteturaspring.todos;

import org.springframework.stereotype.Service;

@Service
public class TodoService {

    private final TodoRepository repository;
    private final TodoValidator validator;
    private final MailSender mailSender;

    public TodoService(TodoRepository todoRepository,TodoValidator validator,MailSender mailSender){
        this.repository = todoRepository;
        this.validator = validator;
        this.mailSender = mailSender;
    }

    public TodoEntity salvar(TodoEntity novoTodo){
        validator.validar(novoTodo);
        return repository.save(novoTodo);

    }

    public void atualizarStatus(TodoEntity todo){

        repository.save(todo);
        String status = todo.getConcluido() == Boolean.TRUE ? "Concluído" : "Não concluído";
        mailSender.enviar("Todo  " + todo.getDescricao() + "foi atualizado para " + status );
    }

    public TodoEntity buscarPorId(Integer id){

        return repository.findById(id).orElse(null);

    }

    public void deletarPorId(Integer id){
        repository.deleteById(id);
    }


}
