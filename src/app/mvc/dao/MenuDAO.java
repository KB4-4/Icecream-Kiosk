package app.mvc.dao;

import app.mvc.dto.ItemDTO;

import java.util.List;

public interface MenuDAO {
    List<ItemDTO> getItems() throws Exception;
}
