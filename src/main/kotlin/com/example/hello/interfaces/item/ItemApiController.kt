package com.example.hello.interfaces.item

import com.example.hello.application.item.ItemFacade
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/items")
class ItemApiController(
    private val itemFacade: ItemFacade,
//    private val itemDtoMapper: ItemDtoMapper
) {

}