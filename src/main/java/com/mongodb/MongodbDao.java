package com.mongodb;

import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;
import java.util.Map;

/**
 * @author: jyh
 * @date: 2019/8/1
 * @description：
 */

@RestController
public class MongodbDao {

    @Resource
    private MongoTemplate mongoTemplate;

    @PostMapping("/saveTest")
    public void saveTest(@RequestBody MongoPojo mongoPojo) {
        mongoTemplate.save(mongoPojo, "test");
    }

    @PostMapping("/findByName")
    public MongoPoj findByName(@RequestBody Map<String, Object> map) {
        Query query = new Query();
        String name = map.get("name").toString();

        if (name != null) {
            query.addCriteria(Criteria.where("name").is(name))                                                                      ;
        }

        MongoPoj mongoPojo = mongoTemplate.findOne(query, MongoPoj.class, "test");
        return mongoPojo;
    }

    @PostMapping("/update")
    public int update(@RequestBody MongoPojo mongoPojo) {
        if(mongoPojo != null) {
            Integer id = mongoPojo.getId();
            Integer age = mongoPojo.getAge();
            String name = mongoPojo.getName();

            if(id != null) {
                Query query = new Query(Criteria.where("id").is(id));
                Update update = new Update().set("age",age).set("name",name);

                //更新查询返回结果集的第一条
                UpdateResult updateResult = mongoTemplate.updateFirst(query, update, MongoPojo.class, "test");

                return 1;
            }else {
                return 0;
            }

        }                                                                                                                                                                                                                                                                              else {
            return 0;
        }

    }

    @PostMapping("delete")
    public Integer delete(@RequestBody MongoPojo mongoPojo) {
        Integer id = mongoPojo.getId();

        if(id != null) {
            Query query = new Query(Criteria.where("id").is(id));
            DeleteResult deleteResult = mongoTemplate.remove(query, MongoPojo.class, "test");
            return 1;
        }else{
            return 0;
        }
    }

}
