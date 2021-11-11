package com.example.hello.infrastructure.item.option

import com.example.hello.domain.item.option.ItemOption
import org.springframework.data.jpa.repository.JpaRepository

interface ItemOptionRepository : JpaRepository<ItemOption, Long> {}
