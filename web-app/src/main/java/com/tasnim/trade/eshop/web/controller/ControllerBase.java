package com.tasnim.trade.eshop.web.controller;

import com.tasnim.trade.eshop.api.Service;
import com.tasnim.trade.eshop.dto.DtoBase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public abstract class ControllerBase<T extends DtoBase> {

    private static final Logger LOGGER = LoggerFactory.getLogger(ControllerBase.class);

    public abstract Service<T> getService();

    public abstract String index();

    @GetMapping("/list")
    public String index(Model model,
                        @RequestParam("page") Optional<Integer> page,
                        @RequestParam("size") Optional<Integer> size) {

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
}
