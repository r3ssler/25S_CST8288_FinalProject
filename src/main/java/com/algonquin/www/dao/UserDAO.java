
package com.algonquin.www.dao;

import com.algonquin.www.domain.UserDTO;

public interface UserDAO {

    UserDTO findUser(String username, String password);

    boolean addUser(UserDTO user);

}
