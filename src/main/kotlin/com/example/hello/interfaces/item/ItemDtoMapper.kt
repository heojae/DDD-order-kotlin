package com.example.hello.interfaces.item

import com.example.hello.domain.item.ItemCommand
import com.example.hello.domain.item.ItemInfo
import org.mapstruct.*


@Mapper(
    componentModel = "spring",
    injectionStrategy = InjectionStrategy.CONSTRUCTOR,
    unmappedTargetPolicy = ReportingPolicy.ERROR
)
interface ItemDtoMapper {

    // register
    @Mappings(Mapping(source = "request.itemOptionGroupList", target = "itemOptionGroupRequestList"))
    fun of(request: ItemDto.RegisterItemRequest): ItemCommand.RegisterItemRequest

    @Mappings(Mapping(source = "itemOptionList", target = "itemOptionRequestList"))
    fun of(request: ItemDto.RegisterItemOptionGroupRequest): ItemCommand.RegisterItemOptionGroupRequest

    fun of(request: ItemDto.RegisterItemOptionRequest): ItemCommand.RegisterItemOptionRequest

    @Mapping(target = "copy", ignore = true)
    fun of(itemToken: String): ItemDto.RegisterResponse

    // retrieve
    @Mappings(Mapping(source = "main.itemOptionGroupList", target = "itemOptionGroupList"))
    fun of(main: ItemInfo.Main): ItemDto.Main

    @Mappings(Mapping(source = "itemOptionInfoList", target = "itemOptionList"))
    fun of(itemOptionGroup: ItemInfo.ItemOptionGroupInfo): ItemDto.ItemOptionGroupInfo

    fun of(itemOption: ItemInfo.ItemOptionInfo): ItemDto.ItemOptionInfo

}

