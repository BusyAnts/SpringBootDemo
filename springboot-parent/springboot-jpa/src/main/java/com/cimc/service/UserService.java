package com.cimc.service;

import com.cimc.dao.UserRepository;
import com.cimc.entity.User;
import com.cimc.entity.UserParam;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;

/**
 * @author chenz
 * @create 2019-09-22 10:00
 */
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Transactional
    public void save(User user) {
        userRepository.save(user);
        int i = 1 / 0;
    }

    public Page<User> findByCondition(UserParam userParam, Pageable pageable) {
        return userRepository.findAll((root, query, cb) -> {
            List<Predicate> predicates = new ArrayList<Predicate>();
            //equal 示例
            if (userParam.getId() != null) {
                predicates.add(cb.equal(root.get("id"), userParam.getId()));
            }
            //like 示例
            if (StringUtils.isNotEmpty(userParam.getName())) {
                predicates.add(cb.like(root.get("name"), "%" + userParam.getName() + "%"));
            }
            //between 示例
            if (userParam.getMinAge() != null && userParam.getMaxAge() != null) {
                Predicate agePredicate = cb.between(root.get("age"), userParam.getMinAge(), userParam.getMaxAge());
                predicates.add(agePredicate);
            }
            //greaterThan 大于等于示例
            if (userParam.getAge() != null) {
                predicates.add(cb.greaterThan(root.get("age"), userParam.getMinAge()));
            }
            return query.where(predicates.toArray(new Predicate[predicates.size()])).getRestriction();
        }, pageable);
    }

}
