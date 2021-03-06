package mybatis.frame;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;

import java.util.HashSet;
import java.util.Set;

/**
 * quizMybatis  配置类
 * Description:  
 * date: 2021/2/13 16:16 
 *
 * @author zuo  
 * @since JDK 1.8
 */
@Slf4j
@Getter
public class QuizConfiguration extends Configuration {

    protected final QuizMapperRegistry quizMapperRegistry;

    protected final Set<String> quizLoadedResources = new HashSet<>();

    private final boolean useDeprecatedExecutor = true;

    public QuizConfiguration() {
        this.quizMapperRegistry = new QuizMapperRegistry(this);
    }

    @Override
    public <T> void addMapper(Class<T> type) {
        quizMapperRegistry.addMapper(type);
    }

    @Override
    public <T> T getMapper(Class<T> type, SqlSession sqlSession) {
        return quizMapperRegistry.getMapper(type, sqlSession);
    }

    @Override
    public void addLoadedResource(String resource) {
        quizLoadedResources.add(resource);
    }

    @Override
    public boolean isResourceLoaded(String resource) {
        return quizLoadedResources.contains(resource);
    }

    public boolean isUseDeprecatedExecutor() {
        return useDeprecatedExecutor;
    }
}