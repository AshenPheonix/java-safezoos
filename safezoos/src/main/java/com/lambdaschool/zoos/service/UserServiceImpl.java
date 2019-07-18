package com.lambdaschool.zoos.service;

import com.lambdaschool.zoos.model.User;
import com.lambdaschool.zoos.model.UserRole;
import com.lambdaschool.zoos.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service(value="userService")
public class UserServiceImpl implements UserService, UserDetailsService {
    @Autowired
    UserRepository userRepo;

    public UserServiceImpl() {
    }

    @Override
    public List<User> findAll() {
        ArrayList<User> temp = new ArrayList<>();
        userRepo.findAll().iterator().forEachRemaining(temp::add);
        return temp;
    }

    @Override
    public User findUserByName(String name) {
        User temp=userRepo.findUserByUsername(name);
        if(temp==null){
            throw new UsernameNotFoundException("Invalid name or password");
        }
        return temp;
    }

    @Override
    public void delete(long id) {

    }

    @Transactional
    @Override
    public User save(User user) {
        User temp=new User();
        temp.setUsername(user.getUsername());
        temp.setPasswordNoEncrypt(user.getPassword());

        ArrayList<UserRole> roles=new ArrayList<>();
        for(UserRole ur : user.getUserRoles()){
            roles.add(new UserRole(ur));
        }

        return userRepo.save(temp);
    }

    @Override
    public User update(User user, long id) {
        return null;
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user=userRepo.findUserByUsername(s);
        if(user==null){
            throw new UsernameNotFoundException("Invalid username or password");
        }
        return new org.springframework.security.core.userdetails.User(user.getUsername(),user.getPassword(),user.getAuthority());
    }
}
