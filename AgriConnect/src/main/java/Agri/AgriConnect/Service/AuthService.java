package Agri.AgriConnect.Service;

import Agri.AgriConnect.Dto.AuthResponseDto;
import Agri.AgriConnect.Dto.LoginRequestDto;
import Agri.AgriConnect.Dto.RegisterRequestDto;

public interface AuthService {

    String register(RegisterRequestDto request);

    AuthResponseDto login(LoginRequestDto request);
}
