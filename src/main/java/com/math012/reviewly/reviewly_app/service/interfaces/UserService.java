package com.math012.reviewly.reviewly_app.service.interfaces;


import com.math012.reviewly.reviewly_app.domain.model.Review;
import com.math012.reviewly.reviewly_app.dto.LoginDTO;
import com.math012.reviewly.reviewly_app.dto.RegisterDTO;

import java.util.List;

public interface UserService {

    RegisterDTO createUser(RegisterDTO user);

    String login(LoginDTO loginDTO);


}
