package com.tasnim.trade.eshop.web.controller;

import com.tasnim.trade.eshop.api.Service;
import com.tasnim.trade.eshop.dto.DtoBase;
import com.tasnim.trade.eshop.type.Principal;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public abstract class ControllerBase<T extends DtoBase> {

    private static final Logger LOGGER = LoggerFactory.getLogger(ControllerBase.class);

    public abstract Service<T> getService();

    public abstract String index();

    public abstract String insert();

    public abstract String all();

    @GetMapping("/index")
    public String index(Model model,
                        @RequestParam("page") Optional<Integer> page,
                        @RequestParam("size") Optional<Integer> size) {

        LOGGER.info("ControllerBase#index");
        LOGGER.info("page: {}", page);
        LOGGER.info("size: {}", size);
        int currentPage = page.orElse(1);
        int pageSize = size.orElse(5);

        Page page1 = getService().findAll(PageRequest.of(currentPage - 1, pageSize));
        model.addAttribute("page", page1);
        int totalPages = page1.getTotalPages();
        if (totalPages > 0) {
            List<Integer> pageNumbers = IntStream
                    .rangeClosed(1, totalPages)
                    .boxed().collect(Collectors.toList());
            model.addAttribute("pageNumbers", pageNumbers);
        }
        return index();
    }

    @GetMapping("/entry")
    public String entry() {
        return insert();
    }

    @PostMapping("/save")
    public String save(@ModelAttribute("model") T entity) {
        getService().save(entity);
        return "redirect:/" + index();
    }

    @ModelAttribute("model")
    public abstract DtoBase getModel();

    @GetMapping("/remove/{id}")
    public String remove(@PathVariable Long id,
                         @RequestParam("page") Optional<Integer> page,
                         @RequestParam("size") Optional<Integer> size) {
        int currentPage = page.orElse(1);
        int pageSize = size.orElse(5);

        getService().delete(id);
        return "redirect:/" + index() + "?size=" + pageSize + "&page=" + currentPage;
    }

    String getLoggedInUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.getPrincipal() != null) {
            if (authentication.getPrincipal() instanceof Principal) {
                Principal principal = (Principal) authentication.getPrincipal();
                return principal.getUsername();
            }
        }
        return null;
    }

    @GetMapping("/all")
    public String all(Model model) {
        model.addAttribute("list", getService().findAll());
        return all();
    }
}
