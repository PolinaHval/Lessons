//package springmvc.controllerRest;
//
//import lombok.RequiredArgsConstructor;
//import org.springframework.http.MediaType;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//import springmvc.converter.UserConverter;
//import springmvc.dto.CreateUserDto;
//import springmvc.model.User;
//import springmvc.service.UserService;
//
//import javax.validation.Valid;
//
//@RestController
//@RequestMapping("/api/v1/registration")
//@RequiredArgsConstructor
//public class ControllerResRegUser {
//
//
//  private final UserService userService;
//  private final UserConverter userConverter;
//
//
//  @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
//  protected CreateUserDto createUser(@Valid @RequestBody final CreateUserDto createUserDto) {
//    User user = userService.createUser(createUserDto.getLogin(), createUserDto.getPassword(), createUserDto.getName(),
//        createUserDto.getLastName(), createUserDto.getPatronymic(), createUserDto.getEmail(),
//        createUserDto.getPhone(), createUserDto.getRole());
//    return userConverter.toDto(user);
//  }
//}
