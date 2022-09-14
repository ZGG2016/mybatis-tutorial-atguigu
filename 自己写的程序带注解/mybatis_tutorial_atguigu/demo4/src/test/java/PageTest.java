import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.zgg.mybatis.bean.Emp;
import org.zgg.mybatis.mapper.EmpMapper;
import org.zgg.mybatis.util.SqlSessionUtils;

import java.util.List;

public class PageTest {

    /**
     * limit index,pageSize
     * index:当前页的起始索引
     * pageSize：每页显示的条数
     * pageNum：当前页的页码
     * index=(pageNum-1)*pageSize
     *
     * 使用MyBatis的分页插件实现分页功能：
     * 1、需要在查询功能之前开启分页
     * PageHelper.startPage(int pageNum, int pageSize);
     * 2、在查询功能之后获取分页相关信息
     * PageInfo<Emp> page = new PageInfo<>(list, 5);
     * list表示分页数据
     * 5表示当前导航分页的数量
     */
    @Test
    public void test() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
        // 查询指定页的数据
//        PageHelper.startPage(2, 4);
//        List<Emp> emps = mapper.selectByExample(null);
//        emps.forEach(System.out::println);

        // 获取分页相关数据
        Page<Object> page = PageHelper.startPage(2, 4);
        List<Emp> emps = mapper.selectByExample(null);
        System.out.println("page: " + page);
        PageInfo<Emp> pageInfo = new PageInfo<>(emps, 3);
        System.out.println("pageInfo: " + pageInfo);
    }
}
/*
pageNum：当前页的页码
pageSize：每页显示的条数
size：当前页显示的真实条数
total：总记录数
pages：总页数
prePage：上一页的页码
nextPage：下一页的页码
isFirstPage/isLastPage：是否为第一页/最后一页
hasPreviousPage/hasNextPage：是否存在上一页/下一页
navigatePages：导航分页的页码数
navigatepageNums：导航分页的页码
 */