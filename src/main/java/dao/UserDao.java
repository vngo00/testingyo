package dao;

import dto.UserDto;

import java.util.ArrayList;
import java.util.List;

// TODO fill this out
public class UserDao implements BaseDao<UserDto> {

  private List<UserDto> userDtoList = new ArrayList<>();

  private static UserDao userDao = new UserDao();

  private UserDao() {

  }


  public static UserDao getInstance() {
    return userDao;
  }

  // TODO fill this out
  @Override
  public void put(UserDto messageDto) {
    userDtoList.add(messageDto);
  }

  // TODO fill this out
  @Override
  public UserDto get(String uniqueId) {

    for (UserDto temp : userDtoList){
      if (temp.getUniqueId().compareTo(uniqueId) == 0){
        return temp;
      }
    }

    return null;
  }

  // TODO fill this out
  @Override
  public List<UserDto> getAll() {
    return userDtoList;
  }
}
