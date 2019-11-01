package mapper;


import entity.User;
import transport.UserTransport;

public class UserMapper {
    public static UserTransport toTransport(User user) {
        if (user == null) {
            return null;
        }

        UserTransport userTransport = new UserTransport();
        userTransport.setFullName(user.getFullName());
        userTransport.setUsername(user.getUsername());
        userTransport.setPassword(user.getPassword());
        userTransport.setId(user.getId());

        return userTransport;
    }

    public static User toEntity(UserTransport userTransport) {
        if (userTransport == null) {
            return null;
        }

        User user = new User();
        user.setFullName(userTransport.getFullName());
        user.setUsername(userTransport.getUsername());
        user.setPassword(userTransport.getPassword());
        user.setId(userTransport.getId());
        return user;
    }
}
