package com.root.content_calendar.controller;

import com.root.content_calendar.model.Content;
import com.root.content_calendar.model.Status;
import com.root.content_calendar.repository.ContentRepository;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/content")
public class ContentController {

    private final ContentRepository repository;

    public ContentController(ContentRepository repository) {
        this.repository = repository;
    }

    @GetMapping()
    public List<Content> findAll() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Content findById(@PathVariable Integer id) {
        return repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Content not found"));
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("")
    public void create(@Valid @RequestBody Content content) {
        repository.save(content);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/{id}")
    public void updateCustomer(
            @RequestBody Content content,
            @PathVariable Integer id
    ) {
        if (!repository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Content not found");
        }
        repository.save(content);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        repository.deleteById(id);
    }
    @GetMapping("/filter/type/{type}")
    public List<Content> filterByType(@PathVariable String type) {
        return repository.findAllByContentType(type.toUpperCase());
    }

}
