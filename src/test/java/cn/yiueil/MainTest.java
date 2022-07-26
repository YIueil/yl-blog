package cn.yiueil;

import cn.yiueil.data.impl.JpaBaseDao;
import cn.yiueil.entity.Blog;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Commit;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring/spring.xml"})
@WebAppConfiguration
public class MainTest {
    @Autowired
    JpaBaseDao baseDao;

    @Test
    @Transactional
    @Commit
    public void test1() {
        Blog blog = new Blog();
        blog.setTitle("hello word");
        blog.setCreateTime(LocalDateTime.now());
        blog.setContent("这是一篇测试文章哦");
        baseDao.save(blog);
    }
}
