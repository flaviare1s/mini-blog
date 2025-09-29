package com.blog.MiniBlog.controllers;

import com.blog.MiniBlog.models.Tag;
import com.blog.MiniBlog.services.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/tags")
public class TagController {
    @Autowired
    private TagService tagService;

    @PostMapping(path = "/save")
    private @ResponseBody Tag save(@RequestBody Tag tag) {
        return TagService.save(tag);
    }

    @GetMapping(path = "/getAll")
    private @ResponseBody List<Tag> getAll() {
        return tagService.getAll();
    }

    @GetMapping(path = "/get")
    private @ResponseBody Tag get(@RequestParam final Long id) {
        return tagService.get(id);
    }

    @PostMapping(path = "/update")
    private @ResponseBody Tag update(@RequestParam final Long id, @RequestBody Tag tag) {
        return tagService.update(id, tag);
    }

    @DeleteMapping(path = "/delete")
    private void delete(@RequestParam final Long id) {
        tagService.delete(id);
    }
}
