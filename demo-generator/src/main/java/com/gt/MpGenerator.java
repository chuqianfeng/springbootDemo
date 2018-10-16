package com.gt;

import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.converts.MySqlTypeConvert;
import com.baomidou.mybatisplus.generator.config.po.TableFill;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.DbColumnType;
import com.baomidou.mybatisplus.generator.config.rules.DbType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

/**
 * @author cqf`
 * @create 2017/7/9
 */
public class MpGenerator {

    // 项目的绝对路径
    private static final String OUTPUTBASEDIR = "E:/cqf/";
    // 生成*.java 的文件路径
    private static final String OUTPUTJAVAMODEL = OUTPUTBASEDIR + "src/main/java";
    // 需要生成的表
    private static final String[] GENERATORTABLENAME = new String[]{
        "picture"
    };
    // 去除表前缀 例如：bus_user 填入bus 生成的 user
    private static final String[] TABLEPREFIX = new String[]{"t"};
    // 生成的包路径
    private static final String PACKAGEPATH = "com.gt";

    private static final String MODULENAME = "";
    // 生成mapper.xml 文件路径
    private static final String GENERATORXMLPATH = OUTPUTBASEDIR + "src/main/java/xml/";
    // Mapper.java Mapper 后缀修改 DAO
    private static final String SETMAPPERNAME = "%sDAO";
    // Mapper.xml Mapper 后缀修改 DAO
    private static final String SETXMLNAME = "%sDAO";
    // Service.java
    private static final String SETSERVICENAME = "%sService";
    // ServiceImpl.java
    private static final String SETSERVICEIMPLNAME = "%sServiceImpl";
    // 数据库方言
    private static final DbType DBTYPE = DbType.MYSQL;
    // 驱动
    private static final String DRIVERNAME = "com.mysql.jdbc.Driver";
    // url
    private static final String URL = "jdbc:mysql://localhost:3306/mall?characterEncoding=utf8";
    // 数据库用户名
    private static final String USERNAME = "root";
    // 密码
    private static final String PWD = "1234";
    // 作者
    private static final String AUTHOR = "cqf";
    private static Logger logger = LoggerFactory.getLogger(MpGenerator.class);

    /**
     * <p>
     * MySQL 生成演示
     * </p>
     */
    public static void main(String[] args) {
        // 自定义需要填充的字段
        List<TableFill> tableFillList = new ArrayList<>();
        tableFillList.add(new TableFill("ASDD_SS", FieldFill.INSERT_UPDATE));
        // 代码生成器
        AutoGenerator mpg = new AutoGenerator().setGlobalConfig(
            // 全局配置
            new GlobalConfig().setOutputDir(OUTPUTJAVAMODEL)//输出目录
                .setFileOverride(true)// 是否覆盖文件
                .setActiveRecord(true)// 开启 activeRecord 模式
                .setEnableCache(false)// XML 二级缓存
                .setBaseResultMap(true)// XML ResultMap
                .setBaseColumnList(true)// XML columList
                .setAuthor(AUTHOR)
                // 自定义文件命名，注意 %s 会自动填充表实体属性！
                .setMapperName(SETMAPPERNAME).setXmlName(SETXMLNAME).setServiceName(SETSERVICENAME)
                .setServiceImplName(SETSERVICEIMPLNAME)
            // .setControllerName("%sAction")
        ).setDataSource(
            // 数据源配置
            new DataSourceConfig().setDbType(DBTYPE)// 数据库类型
                .setTypeConvert(new MySqlTypeConvert() {
                    // 自定义数据库表字段类型转换【可选】
                    @Override
                    public DbColumnType processTypeConvert(String fieldType) {
                        logger.info("转换类型：{}", fieldType);
                        return super.processTypeConvert(fieldType);
                    }
                }).setDriverName(DRIVERNAME).setUsername(USERNAME).setPassword(PWD).setUrl(URL)).setStrategy(
            // 策略配置
            new StrategyConfig()
                // .setCapitalMode(true)// 全局大写命名
                // .setDbColumnUnderline(true)//全局下划线命名
                .setTablePrefix(TABLEPREFIX)// 此处可以修改为您的表前缀
                .setNaming(NamingStrategy.underline_to_camel)// 表名生成策略
                .setInclude(GENERATORTABLENAME) // 需要生成的表
                // .setExclude(new String[]{"test"}) // 排除生成的表
                // 自定义实体父类
                // .setSuperEntityClass("com.baomidou.demo.TestEntity")
                // 自定义实体，公共字段
                .setSuperEntityColumns(new String[]{}).setTableFillList(tableFillList)
                // 自定义 mapper 父类
                .setSuperMapperClass("com.baomidou.mybatisplus.mapper.BaseMapper")
                // 自定义 service 父类
                .setSuperServiceClass("com.gt..base.BaseService")
                // 自定义 service 实现类父类
                .setSuperServiceImplClass("com.gt.eat.base.BaseServiceImpl")
                // 自定义 controller 父类
                .setSuperControllerClass("com.gt.eat.base.BaseController")
                // 【实体】是否生成字段常量（默认 false）
                // .setEntityColumnConstant(true)
                // 【实体】是否为构建者模型（默认 false）
                // 【实体】是否为lombok模型（默认 false）
                .setEntityLombokModel(true)
            // Boolean类型字段是否移除is前缀处理
            // .setEntityBooleanColumnRemoveIsPrefix(true)
            // .setRestControllerStyle(true)
            // .setControllerMappingHyphenStyle(true)
        ).setPackageInfo(
            // 包配置
            new PackageConfig().setModuleName(MODULENAME).setParent(PACKAGEPATH)// 自定义包路径
            //                        .setController("controller")// 这里是控制器包名，默认 web
        ).setCfg(
            // 注入自定义配置，可以在 VM 中使用 cfg.abc 设置的值
            new InjectionConfig() {
                @Override
                public void initMap() {
                    Map<String, Object> map = new HashMap<>();
                    map.put("abc", this.getConfig().getGlobalConfig().getAuthor() + "-mp");
                    this.setMap(map);
                }
            }.setFileOutConfigList(Arrays.<FileOutConfig>asList(new FileOutConfig("/templates/mapper.xml.vm") {
                // 自定义输出文件目录
                @Override
                public String outputFile(TableInfo tableInfo) {
                    return GENERATORXMLPATH + tableInfo.getXmlName() + ".xml";
                }
            }))).setTemplate(
            // 关闭默认 xml 生成，调整生成 至 根目录
            new TemplateConfig().setXml(null)
            // 自定义模板配置，模板可以参考源码 /mybatis-plus/src/main/resources/template 使用 copy
            // 至您项目 src/main/resources/template 目录下，模板名称也可自定义如下配置：
        );

        // 执行生成
        mpg.execute();
    }
}
