package com.example.notes.controller;

import com.example.notes.entity.Note;
import com.example.notes.service.NoteService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@RequiredArgsConstructor
@Controller
@RequestMapping(value = "/note")
public class NoteController {
    private final NoteService noteService;

    @RequestMapping(method = RequestMethod.GET, value = "/list")
    public ModelAndView getNotes() {
        ModelAndView result = new ModelAndView("list");
        result.addObject("notes", noteService.listAll());
        return result;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/create")
    public ModelAndView getCreateNote() {
        return new ModelAndView("create-note");
    }

    @RequestMapping(method = RequestMethod.POST, value = "/create")
    public String postCreateNote(@ModelAttribute("addedNote") Note newNote) {
        noteService.save(newNote);
        return "redirect:/note/list";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/delete")
    public String deleteNote(@RequestParam(value = "id") String id) {
        noteService.deleteById(Long.parseLong(id));
        return "redirect:/note/list";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/edit")
    public ModelAndView getEditNote(@RequestParam(value = "id") String id) {
        if (noteService.exists(Long.parseLong(id))) {
            ModelAndView result = new ModelAndView("edit-note");
            result.addObject("note", noteService.getById(Long.parseLong(id)));
            return result;
        }
        return noteNotFound(id);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/edit")
    public String postEditNote(@ModelAttribute("editedNote") Note note) {
        noteService.save(note);
        return "redirect:/note/list";
    }

    public ModelAndView noteNotFound(String id) {
        ModelAndView result = new ModelAndView("note-not-found");
        result.addObject("text", id);
        return result;
    }
}
