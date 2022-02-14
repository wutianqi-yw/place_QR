package com.example.test2.Config.AreaMulTreeStore;

import com.example.test2.POJO.Area;

public class Harbin01 implements GetArea {

    public void setAreaStore(Area fatherArea) {
        // setter - area1 哈尔滨市
        fatherArea.setChildren(getLevel02(fatherArea));
    }

    /**
     * 设置 ‘区级’ 子孩子
     *
     * @param fatherArea
     * @return
     */
    private Area[] getLevel02(Area fatherArea) {
        // area1 - 哈尔滨市 - area_level = 2
        Area area1201 = Area.builder().id(1201L).name("道里区").father(fatherArea).area_level(2).risk_level(1).children(null).build();
        Area area1202 = Area.builder().id(1202L).name("南岗区").father(fatherArea).area_level(2).risk_level(1).children(null).build();
        Area area1203 = Area.builder().id(1203L).name("外道区").father(fatherArea).area_level(2).risk_level(1).children(null).build();
        Area area1204 = Area.builder().id(1204L).name("平房区").father(fatherArea).area_level(2).risk_level(1).children(null).build();
        Area area1205 = Area.builder().id(1205L).name("松北区").father(fatherArea).area_level(2).risk_level(1).children(null).build();
        Area area1206 = Area.builder().id(1206L).name("香坊区").father(fatherArea).area_level(2).risk_level(1).children(null).build();
        Area area1207 = Area.builder().id(1207L).name("呼兰区").father(fatherArea).area_level(2).risk_level(1).children(null).build();
        Area area1208 = Area.builder().id(1208L).name("阿城区").father(fatherArea).area_level(2).risk_level(1).children(null).build();
        Area area1209 = Area.builder().id(1209L).name("双城区").father(fatherArea).area_level(2).risk_level(1).children(null).build();
        Area area1210 = Area.builder().id(1210L).name("依兰县").father(fatherArea).area_level(2).risk_level(1).children(null).build();
        Area area1211 = Area.builder().id(1211L).name("方正县").father(fatherArea).area_level(2).risk_level(1).children(null).build();
        Area area1212 = Area.builder().id(1212L).name("宾县").father(fatherArea).area_level(2).risk_level(1).children(null).build();
        Area area1213 = Area.builder().id(1213L).name("巴彦县").father(fatherArea).area_level(2).risk_level(1).children(null).build();
        Area area1214 = Area.builder().id(1214L).name("木兰县").father(fatherArea).area_level(2).risk_level(1).children(null).build();
        Area area1215 = Area.builder().id(1215L).name("通河县").father(fatherArea).area_level(2).risk_level(1).children(null).build();
        Area area1216 = Area.builder().id(1216L).name("延寿县").father(fatherArea).area_level(2).risk_level(1).children(null).build();
        Area area1217 = Area.builder().id(1217L).name("尚志市").father(fatherArea).area_level(2).risk_level(1).children(null).build();
        Area area1218 = Area.builder().id(1218L).name("五常市").father(fatherArea).area_level(2).risk_level(1).children(null).build();

        Area[] areas = new Area[]{area1201, area1202, area1203, area1204, area1205, area1206, area1207, area1208, area1209, area1210, area1211, area1212, area1213, area1214, area1215, area1216, area1217, area1218};

        // 顺序调用 添加孩子
        for (Area area : areas) {
            getLevel03(area);
        }

        return areas;
    }

    /**
     * 顺序添加 某区 获得 ‘街道级’ 子孩子
     *
     * @param fatherArea
     * @return
     */
    private void getLevel03(Area fatherArea) {

        Area[] areas = null;

        //某区 获得 ‘街道级’ 子孩子
        switch (fatherArea.getName()) {
            case "道里区":
                areas = getDaoliqu(fatherArea);
                break;
            default:
                break;
        }

        // 添加孩子
        fatherArea.setChildren(areas);

        // 顺序循环 某街道 获得 ‘社区级’孩子
        if (areas != null) {
            for (Area area : areas) {
                getLevel04(area);
            }
        }

    }

    public Area getLevel04(Area fatherArea) {
        Area[] areas = null;

        switch (fatherArea.getName()) {
            case "兆麟街道":
                areas = getZhaoLinStreet(fatherArea);
                break;
            case "新阳路街道":
                areas = getXinYangStreet(fatherArea);
                break;
            case "抚顺街道":
                areas = getFuSunStreet(fatherArea);
                break;
            case "共乐街道":
                areas = getGongleStreet(fatherArea);
                break;
            case "新华街道":
                areas = getXinhuaStreet(fatherArea);
                break;
            case "城乡路街道":
                areas = getChengxiangStreet(fatherArea);
                break;
            case "工农街道":
                areas = getGongnongStreet(fatherArea);
                break;
            case "尚志街道":
                areas = getShangzhiStreet(fatherArea);
                break;
            case "斯大林街道":
                areas = getSidalinStreet(fatherArea);
                break;
            case "通江街道":
                areas = getTongjiangStreet(fatherArea);
                break;
            case "经纬街道":
                areas = getJingweiStreet(fatherArea);
                break;
            case "工程街道":
                areas = getGongchengStreet(fatherArea);
                break;
            case "安静街道":
                areas = getAnjingStreet(fatherArea);
                break;
            case "安和街道":
                areas = getAnheStreet(fatherArea);
                break;
            case "正阳河街道":
                areas = getZhengyangHeStreet(fatherArea);
                break;
            case "建国街道":
                areas = getJianguoStreet(fatherArea);
                break;
            case "康安街道":
                areas = getKanganStreet(fatherArea);
                break;
            case "爱建街道":
                areas = getAijianStreet(fatherArea);
                break;
            case "群力街道":
                areas = getQunliStreet(fatherArea);
                break;
            case "太平镇":
                areas = getTaipingTown(fatherArea);
                break;
            case "新农镇":
                areas = getXinongTown(fatherArea);
                break;
            case "新发镇":
                areas = getXinfaTown(fatherArea);
                break;
            case "榆树镇":
                areas = getYushuTown(fatherArea);
                break;
            case "新发街道":
                areas = getXinfaStreet(fatherArea);
                break;
        }

        fatherArea.setChildren(areas);

        return fatherArea;
    }

    /**
     * 道里区的街道
     *
     * @param fatherArea
     * @return Area[]
     */
    private Area[] getDaoliqu(Area fatherArea) {
        // area1201 - 道里区 - area_level = 3
        Area area101301 = Area.builder().id(101301L).name("兆麟街道").father(fatherArea).area_level(3).risk_level(1).children(null).build();
        Area area101302 = Area.builder().id(101302L).name("新阳路街道").father(fatherArea).area_level(3).risk_level(1).children(null).build();
        Area area101303 = Area.builder().id(101303L).name("抚顺街道").father(fatherArea).area_level(3).risk_level(1).children(null).build();
        Area area101304 = Area.builder().id(101304L).name("共乐街道").father(fatherArea).area_level(3).risk_level(1).children(null).build();
        Area area101305 = Area.builder().id(101305L).name("新华街道").father(fatherArea).area_level(3).risk_level(1).children(null).build();
        Area area101306 = Area.builder().id(101306L).name("城乡路街道").father(fatherArea).area_level(3).risk_level(1).children(null).build();
        Area area101307 = Area.builder().id(101307L).name("工农街道").father(fatherArea).area_level(3).risk_level(1).children(null).build();
        Area area101308 = Area.builder().id(101308L).name("尚志街道").father(fatherArea).area_level(3).risk_level(1).children(null).build();
        Area area101309 = Area.builder().id(101309L).name("斯大林街道").father(fatherArea).area_level(3).risk_level(1).children(null).build();
        Area area101310 = Area.builder().id(101310L).name("通江街道").father(fatherArea).area_level(3).risk_level(1).children(null).build();
        Area area101311 = Area.builder().id(101311L).name("经纬街道").father(fatherArea).area_level(3).risk_level(1).children(null).build();
        Area area101312 = Area.builder().id(101312L).name("工程街道").father(fatherArea).area_level(3).risk_level(1).children(null).build();
        Area area101313 = Area.builder().id(101313L).name("安静街道").father(fatherArea).area_level(3).risk_level(1).children(null).build();
        Area area101314 = Area.builder().id(101314L).name("安和街道").father(fatherArea).area_level(3).risk_level(1).children(null).build();
        Area area101315 = Area.builder().id(101315L).name("正阳河街道").father(fatherArea).area_level(3).risk_level(1).children(null).build();
        Area area101316 = Area.builder().id(101316L).name("建国街道").father(fatherArea).area_level(3).risk_level(1).children(null).build();
        Area area101317 = Area.builder().id(101317L).name("康安街道").father(fatherArea).area_level(3).risk_level(1).children(null).build();
        Area area101318 = Area.builder().id(101318L).name("爱建街道").father(fatherArea).area_level(3).risk_level(1).children(null).build();
        Area area101319 = Area.builder().id(101319L).name("群力街道").father(fatherArea).area_level(3).risk_level(1).children(null).build();
        Area area101320 = Area.builder().id(101320L).name("太平镇").father(fatherArea).area_level(3).risk_level(1).children(null).build();
        Area area101321 = Area.builder().id(101321L).name("新发镇").father(fatherArea).area_level(3).risk_level(1).children(null).build();
        Area area101322 = Area.builder().id(101322L).name("新农镇").father(fatherArea).area_level(3).risk_level(1).children(null).build();
        Area area101323 = Area.builder().id(101323L).name("榆树镇").father(fatherArea).area_level(3).risk_level(1).children(null).build();
        Area area101324 = Area.builder().id(101324L).name("新发街道").father(fatherArea).area_level(3).risk_level(1).children(null).build();

        // setter - area1201 道里区
        return new Area[]{area101301, area101302, area101303, area101304, area101305, area101306, area101307, area101308, area101309, area101310, area101311, area101312, area101313, area101314, area101315, area101316, area101317, area101318, area101319, area101320, area101321, area101322, area101323, area101324};
    }

    /**
     * 兆麟街道
     *
     * @return
     */
    private Area[] getZhaoLinStreet(Area fatherArea) {
        // area101301 - 兆麟街道 - area_level = 4
        Area area10101401 = Area.builder().id(10101401L).name("兆麟社区").father(fatherArea).area_level(4).risk_level(1).children(null).build();
        Area area10101402 = Area.builder().id(10101402L).name("索菲亚社区").father(fatherArea).area_level(4).risk_level(1).children(null).build();
        Area area10101403 = Area.builder().id(10101402L).name("省报社社区").father(fatherArea).area_level(4).risk_level(1).children(null).build();
        Area area10101404 = Area.builder().id(10101403L).name("森林社区").father(fatherArea).area_level(4).risk_level(1).children(null).build();
        return new Area[]{area10101401, area10101402, area10101403, area10101404};

    }

    /**
     * 新阳路街道
     *
     * @return
     */
    private Area[] getXinYangStreet(Area fatherArea) {
        // area101302 - 新阳路街道 - area_level = 4
        Area area10102401 = Area.builder().id(10102401L).name("新阳社区").father(fatherArea).area_level(4).risk_level(1).children(null).build();
        Area area10102402 = Area.builder().id(10102402L).name("银都社区").father(fatherArea).area_level(4).risk_level(1).children(null).build();
        Area area10102403 = Area.builder().id(10102403L).name("地徳里北段社区").father(fatherArea).area_level(4).risk_level(1).children(null).build();
        Area area10102404 = Area.builder().id(10102404L).name("安化北段社区").father(fatherArea).area_level(4).risk_level(1).children(null).build();

        return new Area[]{area10102401, area10102402, area10102403, area10102404};
    }

    /**
     * 抚顺街道
     *
     * @return
     */
    private Area[] getFuSunStreet(Area fatherArea) {
        // area101303 - 抚顺街道 - area_level = 4
        Area area10103401 = Area.builder().id(10103401L).name("安详社区").father(fatherArea).area_level(4).risk_level(1).children(null).build();
        Area area10103402 = Area.builder().id(10103402L).name("安吉社区").father(fatherArea).area_level(4).risk_level(1).children(null).build();
        Area area10103403 = Area.builder().id(10103403L).name("抚顺社区").father(fatherArea).area_level(4).risk_level(1).children(null).build();
        Area area10103404 = Area.builder().id(10103404L).name("地徳里社区").father(fatherArea).area_level(4).risk_level(1).children(null).build();
        Area area10103405 = Area.builder().id(10103405L).name("抚安社区").father(fatherArea).area_level(4).risk_level(1).children(null).build();

        return new Area[]{area10103401, area10103402, area10103403, area10103404, area10103405};
    }

    /**
     * 共乐街道
     *
     * @return
     */
    private Area[] getGongleStreet(Area fatherArea) {

        // area101304 - 共乐街道 - area_level = 4
        Area area10104401 = Area.builder().id(10104401L).name("大民兴东段社区").father(fatherArea).area_level(4).risk_level(1).children(null).build();
        Area area10104402 = Area.builder().id(10104402L).name("大民兴西段社区").father(fatherArea).area_level(4).risk_level(1).children(null).build();
        Area area10104403 = Area.builder().id(10104403L).name("大民兴中段社区").father(fatherArea).area_level(4).risk_level(1).children(null).build();
        Area area10104404 = Area.builder().id(10104404L).name("民桥社区").father(fatherArea).area_level(4).risk_level(1).children(null).build();
        Area area10104405 = Area.builder().id(10104405L).name("民茂社区").father(fatherArea).area_level(4).risk_level(1).children(null).build();
        Area area10104406 = Area.builder().id(10104406L).name("福同社区").father(fatherArea).area_level(4).risk_level(1).children(null).build();
        Area area10104407 = Area.builder().id(10104407L).name("光华社区").father(fatherArea).area_level(4).risk_level(1).children(null).build();
        Area area10104408 = Area.builder().id(10104408L).name("民众社区").father(fatherArea).area_level(4).risk_level(1).children(null).build();
        Area area10104409 = Area.builder().id(10104409L).name("民安社区").father(fatherArea).area_level(4).risk_level(1).children(null).build();
        Area area10104410 = Area.builder().id(10104410L).name("民庆社区").father(fatherArea).area_level(4).risk_level(1).children(null).build();
        Area area10104411 = Area.builder().id(10104411L).name("福乐湾社区").father(fatherArea).area_level(4).risk_level(1).children(null).build();
        Area area10104412 = Area.builder().id(10104412L).name("欧洲新城社区").father(fatherArea).area_level(4).risk_level(1).children(null).build();

        // setter - area101304 共乐街道
        return new Area[]{area10104401, area10104402, area10104403, area10104404, area10104405, area10104406, area10104407, area10104408, area10104409, area10104410, area10104411, area10104412};
    }

    /**
     * 新华街道
     *
     * @return
     */
    private Area[] getXinhuaStreet(Area fatherArea) {
        // area101305 - 新华街道 - area_level = 4
        Area area10105401 = Area.builder().id(10105401L).name("清河湾社区").father(fatherArea).area_level(4).risk_level(1).children(null).build();
        Area area10105402 = Area.builder().id(10105402L).name("埃德蒙顿路社区").father(fatherArea).area_level(4).risk_level(1).children(null).build();
        Area area10105403 = Area.builder().id(10105403L).name("大发社区").father(fatherArea).area_level(4).risk_level(1).children(null).build();
        Area area10105404 = Area.builder().id(10105404L).name("新华社区").father(fatherArea).area_level(4).risk_level(1).children(null).build();
        Area area10105405 = Area.builder().id(10105405L).name("顾新路社区").father(fatherArea).area_level(4).risk_level(1).children(null).build();
        Area area10105406 = Area.builder().id(10105406L).name("乡政社区").father(fatherArea).area_level(4).risk_level(1).children(null).build();
        Area area10105407 = Area.builder().id(10105407L).name("恒祥城社区").father(fatherArea).area_level(4).risk_level(1).children(null).build();
        Area area10105408 = Area.builder().id(10105408L).name("天合社区").father(fatherArea).area_level(4).risk_level(1).children(null).build();
        Area area10105409 = Area.builder().id(10105409L).name("理工大学社区").father(fatherArea).area_level(4).risk_level(1).children(null).build();
        Area area10105410 = Area.builder().id(10105410L).name("顾乡电信社区").father(fatherArea).area_level(4).risk_level(1).children(null).build();

        // setter - area101305 新华街道
        return new Area[]{area10105401, area10105402, area10105403, area10105404, area10105405, area10105406, area10105407, area10105408, area10105409, area10105410};
    }

    /**
     * 城乡路街道
     *
     * @return
     */
    private Area[] getChengxiangStreet(Area fatherArea) {
        // area101306 - 城乡路街道 - area_level = 4
        Area area10106401 = Area.builder().id(10106401L).name("报达家园社区").father(fatherArea).area_level(4).risk_level(1).children(null).build();
        Area area10106402 = Area.builder().id(10106402L).name("恒大悦府社区").father(fatherArea).area_level(4).risk_level(1).children(null).build();
        Area area10106403 = Area.builder().id(10106403L).name("丽河湾社区").father(fatherArea).area_level(4).risk_level(1).children(null).build();
        Area area10106404 = Area.builder().id(10106404L).name("美河湾社区").father(fatherArea).area_level(4).risk_level(1).children(null).build();
        Area area10106405 = Area.builder().id(10106405L).name("天薇社区").father(fatherArea).area_level(4).risk_level(1).children(null).build();
        Area area10106406 = Area.builder().id(10106406L).name("翡翠城社区").father(fatherArea).area_level(4).risk_level(1).children(null).build();
        Area area10106407 = Area.builder().id(10106407L).name("红星社区").father(fatherArea).area_level(4).risk_level(1).children(null).build();
        Area area10106408 = Area.builder().id(10106408L).name("丽江社区").father(fatherArea).area_level(4).risk_level(1).children(null).build();
        Area area10106409 = Area.builder().id(10106409L).name("迎宾社区").father(fatherArea).area_level(4).risk_level(1).children(null).build();
        Area area10106410 = Area.builder().id(10106410L).name("阳光社区").father(fatherArea).area_level(4).risk_level(1).children(null).build();
        Area area10106411 = Area.builder().id(10106411L).name("西雅图社区").father(fatherArea).area_level(4).risk_level(1).children(null).build();
        Area area10106412 = Area.builder().id(10106412L).name("秀河湾社区").father(fatherArea).area_level(4).risk_level(1).children(null).build();
        Area area10106413 = Area.builder().id(10106413L).name("福尚社区").father(fatherArea).area_level(4).risk_level(1).children(null).build();
        Area area10106414 = Area.builder().id(10106414L).name("西客站社区").father(fatherArea).area_level(4).risk_level(1).children(null).build();

        // setter - area101306 新华街道
        return new Area[]{area10106401, area10106402, area10106403, area10106404, area10106405, area10106406, area10106407, area10106408, area10106409, area10106410, area10106411, area10106412, area10106413, area10106414};
    }

    /**
     * 工农街道
     *
     * @return
     */
    private Area[] getGongnongStreet(Area fatherArea) {
        // area101307 - 工农街道 - area_level = 4
        Area area10107401 = Area.builder().id(10107401L).name("天鹅湾社区").father(fatherArea).area_level(4).risk_level(1).children(null).build();
        Area area10107402 = Area.builder().id(10107402L).name("新城社区").father(fatherArea).area_level(4).risk_level(1).children(null).build();
        Area area10107403 = Area.builder().id(10107403L).name("景江社区").father(fatherArea).area_level(4).risk_level(1).children(null).build();
        Area area10107404 = Area.builder().id(10107404L).name("美晨社区").father(fatherArea).area_level(4).risk_level(1).children(null).build();
        Area area10107405 = Area.builder().id(10107405L).name("观江社区").father(fatherArea).area_level(4).risk_level(1).children(null).build();
        Area area10107406 = Area.builder().id(10107406L).name("漫步巴黎社区").father(fatherArea).area_level(4).risk_level(1).children(null).build();
        Area area10107407 = Area.builder().id(10107407L).name("盛和世纪社区").father(fatherArea).area_level(4).risk_level(1).children(null).build();
        Area area10107408 = Area.builder().id(10107408L).name("盛和天下社区").father(fatherArea).area_level(4).risk_level(1).children(null).build();
        Area area10107409 = Area.builder().id(10107409L).name("玫瑰湾社区").father(fatherArea).area_level(4).risk_level(1).children(null).build();
        Area area10107410 = Area.builder().id(10107410L).name("宝石花园社区").father(fatherArea).area_level(4).risk_level(1).children(null).build();
        Area area10107411 = Area.builder().id(10107411L).name("金河社区").father(fatherArea).area_level(4).risk_level(1).children(null).build();
        Area area10107412 = Area.builder().id(10107412L).name("恒盛社区").father(fatherArea).area_level(4).risk_level(1).children(null).build();
        Area area10107413 = Area.builder().id(10107413L).name("金安社区").father(fatherArea).area_level(4).risk_level(1).children(null).build();
        Area area10107414 = Area.builder().id(10107414L).name("丽江社区").father(fatherArea).area_level(4).risk_level(1).children(null).build();
        Area area10107415 = Area.builder().id(10107415L).name("兴江社区").father(fatherArea).area_level(4).risk_level(1).children(null).build();
        Area area10107416 = Area.builder().id(10107416L).name("赫郡社区").father(fatherArea).area_level(4).risk_level(1).children(null).build();

        // setter - area101307 工农街道
       return new Area[]{area10107401, area10107402, area10107403, area10107404, area10107405, area10107406, area10107407, area10107408, area10107409, area10107410, area10107411, area10107412, area10107413, area10107414, area10107415, area10107416};
    }

    /**
     * 尚志街道
     *
     * @return
     */
    private Area[] getShangzhiStreet(Area fatherArea) {
        // area101308 - 尚志街道 - area_level = 4
        Area area10108401 = Area.builder().id(10108401L).name("中央大街社区").father(fatherArea).area_level(4).risk_level(1).children(null).build();
        Area area10108402 = Area.builder().id(10108402L).name("西十五街道社区").father(fatherArea).area_level(4).risk_level(1).children(null).build();
        Area area10108403 = Area.builder().id(10108403L).name("斜角街社区").father(fatherArea).area_level(4).risk_level(1).children(null).build();

        // setter - area101308 尚志街道
       return new Area[]{area10108401, area10108402, area10108403};
    }

    /**
     * 斯大林街道
     *
     * @return
     */
    private Area[] getSidalinStreet(Area fatherArea) {
        // area101309 - 斯大林街道 - area_level = 4
        Area area10109401 = Area.builder().id(10109401L).name("地段北社区").father(fatherArea).area_level(4).risk_level(1).children(null).build();
        Area area10109402 = Area.builder().id(10109402L).name("花圃社区").father(fatherArea).area_level(4).risk_level(1).children(null).build();
        Area area10109403 = Area.builder().id(10109403L).name("江桥社区").father(fatherArea).area_level(4).risk_level(1).children(null).build();

        // setter - area101309 斯大林街道
        return new Area[]{area10109401, area10109402, area10109403};
    }

    /**
     * 通江街道
     *
     * @return
     */
    private Area[] getTongjiangStreet(Area fatherArea) {
        // area101310 - 通江街道 - area_level = 4
        Area area10110401 = Area.builder().id(114L).name("上红社区").father(fatherArea).area_level(4).risk_level(1).children(null).build();
        Area area10110402 = Area.builder().id(115L).name("友谊社区").father(fatherArea).area_level(4).risk_level(1).children(null).build();
        Area area10110403 = Area.builder().id(116L).name("红专社区").father(fatherArea).area_level(4).risk_level(1).children(null).build();
        Area area10110404 = Area.builder().id(117L).name("红星广场社区").father(fatherArea).area_level(4).risk_level(1).children(null).build();

        // setter - area101310 通江街道
        return new Area[]{area10110401, area10110402, area10110403, area10110404};
    }

    /**
     * 经纬街道
     *
     * @return
     */
    private Area[] getJingweiStreet(Area fatherArea) {
        // area101311 - 经纬街道 - area_level = 4
        Area area10111401 = Area.builder().id(10111401L).name("北安社区").father(fatherArea).area_level(4).risk_level(1).children(null).build();
        Area area10111402 = Area.builder().id(10111402L).name("霁虹桥社区").father(fatherArea).area_level(4).risk_level(1).children(null).build();
        Area area10111403 = Area.builder().id(10111403L).name("经纬东段社区").father(fatherArea).area_level(4).risk_level(1).children(null).build();
        Area area10111404 = Area.builder().id(10111404L).name("经纬七社区").father(fatherArea).area_level(4).risk_level(1).children(null).build();
        Area area10111405 = Area.builder().id(10111405L).name("大安社区").father(fatherArea).area_level(4).risk_level(1).children(null).build();

        // setter - area101311 经纬街道
        return new Area[]{area10111401, area10111402, area10111403, area10111404, area10111405};
    }

    /**
     * 工程街道
     *
     * @return
     */
    private Area[] getGongchengStreet(Area fatherArea) {
        // area101312 - 工程街道 - area_level = 4
        Area area10112401 = Area.builder().id(10112401L).name("友谊小区社区").father(fatherArea).area_level(4).risk_level(1).children(null).build();
        Area area10112402 = Area.builder().id(10112402L).name("工部南段社区").father(fatherArea).area_level(4).risk_level(1).children(null).build();
        Area area10112403 = Area.builder().id(10112403L).name("工程社区").father(fatherArea).area_level(4).risk_level(1).children(null).build();
        Area area10112404 = Area.builder().id(10112404L).name("工程东段社区").father(fatherArea).area_level(4).risk_level(1).children(null).build();
        Area area10112405 = Area.builder().id(10112405L).name("红专西段社区").father(fatherArea).area_level(4).risk_level(1).children(null).build();

        // setter - area101312 工程街道
        return new Area[]{area10112401, area10112402, area10112403, area10112404, area10112405};
    }

    /**
     * 安静街道
     *
     * @return
     */
    private Area[] getAnjingStreet(Area fatherArea) {
        // area101313 - 安静街道 - area_level = 4
        Area area10113401 = Area.builder().id(10113401L).name("安松社区").father(fatherArea).area_level(4).risk_level(1).children(null).build();
        Area area10113402 = Area.builder().id(10113402L).name("安正社区").father(fatherArea).area_level(4).risk_level(1).children(null).build();
        Area area10113403 = Area.builder().id(10113403L).name("安顺社区").father(fatherArea).area_level(4).risk_level(1).children(null).build();
        Area area10113404 = Area.builder().id(10113404L).name("安生社区").father(fatherArea).area_level(4).risk_level(1).children(null).build();
        Area area10113405 = Area.builder().id(10113405L).name("安国社区").father(fatherArea).area_level(4).risk_level(1).children(null).build();
        Area area10113406 = Area.builder().id(10113406L).name("安康社区").father(fatherArea).area_level(4).risk_level(1).children(null).build();
        Area area10113407 = Area.builder().id(10113407L).name("安静社区").father(fatherArea).area_level(4).risk_level(1).children(null).build();
        Area area10113408 = Area.builder().id(10113408L).name("安良社区").father(fatherArea).area_level(4).risk_level(1).children(null).build();

        // setter - area101313 安静街道
        return new Area[]{area10113401, area10113402, area10113403, area10113404, area10113405, area10113406, area10113407, area10113408};
    }

    /**
     * 安和街道
     *
     * @return
     */
    private Area[] getAnheStreet(Area fatherArea) {
        // area101314 - 安和街道 - area_level = 4
        Area area10114401 = Area.builder().id(10114401L).name("安和社区").father(fatherArea).area_level(4).risk_level(1).children(null).build();
        Area area10114402 = Area.builder().id(10114402L).name("安德社区").father(fatherArea).area_level(4).risk_level(1).children(null).build();
        Area area10114403 = Area.builder().id(10114403L).name("广发社区").father(fatherArea).area_level(4).risk_level(1).children(null).build();
        Area area10114404 = Area.builder().id(10114404L).name("正义社区").father(fatherArea).area_level(4).risk_level(1).children(null).build();
        Area area10114405 = Area.builder().id(10114405L).name("安广社区").father(fatherArea).area_level(4).risk_level(1).children(null).build();

        // setter - area101314 安和街道
        return new Area[]{area10114401, area10114402, area10114403, area10114404, area10114405};
    }

    /**
     * 正阳河街道
     *
     * @return
     */
    private Area[] getZhengyangHeStreet(Area fatherArea) {
        // area101315 - 正阳河街道 - area_level = 4
        Area area10115401 = Area.builder().id(10115401L).name("哈木器社区").father(fatherArea).area_level(4).risk_level(1).children(null).build();
        Area area10115402 = Area.builder().id(10115402L).name("河江社区").father(fatherArea).area_level(4).risk_level(1).children(null).build();
        Area area10115403 = Area.builder().id(10115403L).name("河政社区").father(fatherArea).area_level(4).risk_level(1).children(null).build();
        Area area10115404 = Area.builder().id(10115404L).name("河源社区").father(fatherArea).area_level(4).risk_level(1).children(null).build();
        Area area10115405 = Area.builder().id(10115405L).name("河梁社区").father(fatherArea).area_level(4).risk_level(1).children(null).build();
        Area area10115406 = Area.builder().id(10115406L).name("前进社区").father(fatherArea).area_level(4).risk_level(1).children(null).build();
        Area area10115407 = Area.builder().id(10115407L).name("河曲社区").father(fatherArea).area_level(4).risk_level(1).children(null).build();
        Area area10115408 = Area.builder().id(10115408L).name("富力江湾社区").father(fatherArea).area_level(4).risk_level(1).children(null).build();
        Area area10115409 = Area.builder().id(10115409L).name("公路大桥社区").father(fatherArea).area_level(4).risk_level(1).children(null).build();
        Area area10115410 = Area.builder().id(10115410L).name("融府大厦社区").father(fatherArea).area_level(4).risk_level(1).children(null).build();
        Area area10115411 = Area.builder().id(10115411L).name("何松社区").father(fatherArea).area_level(4).risk_level(1).children(null).build();
        Area area10115412 = Area.builder().id(10115412L).name("河阳社区").father(fatherArea).area_level(4).risk_level(1).children(null).build();

        // setter - area101315 正阳河街道
        return new Area[]{area10115401, area10115402, area10115403, area10115404, area10115405, area10115406, area10115407, area10115408, area10115409, area10115410, area10115411, area10115412};
    }

    /**
     * 建国街道
     *
     * @return
     */
    private Area[] getJianguoStreet(Area fatherArea) {
        // area101316 - 建国街道 - area_level = 4
        Area area10116401 = Area.builder().id(10116401L).name("建国北二社区").father(fatherArea).area_level(4).risk_level(1).children(null).build();
        Area area10116402 = Area.builder().id(10116402L).name("建国公园社区").father(fatherArea).area_level(4).risk_level(1).children(null).build();
        Area area10116403 = Area.builder().id(10116403L).name("钢柱社区").father(fatherArea).area_level(4).risk_level(1).children(null).build();
        Area area10116404 = Area.builder().id(10116404L).name("建河社区").father(fatherArea).area_level(4).risk_level(1).children(null).build();
        Area area10116405 = Area.builder().id(10116405L).name("建议社区").father(fatherArea).area_level(4).risk_level(1).children(null).build();

        // setter - area101316 建国街道
        return new Area[]{area10116401, area10116402, area10116403, area10116404, area10116405};
    }

    /**
     * 康安街道
     *
     * @return
     */
    private Area[] getKanganStreet(Area fatherArea) {
        // area101317 - 康安街道 - area_level = 4
        Area area10117401 = Area.builder().id(10117401L).name("河柏社区").father(fatherArea).area_level(4).risk_level(1).children(null).build();
        Area area10117402 = Area.builder().id(10117402L).name("新天地家园社区").father(fatherArea).area_level(4).risk_level(1).children(null).build();
        Area area10117403 = Area.builder().id(10117403L).name("康安社区").father(fatherArea).area_level(4).risk_level(1).children(null).build();
        Area area10117404 = Area.builder().id(10117404L).name("海富康城社区").father(fatherArea).area_level(4).risk_level(1).children(null).build();
        Area area10117405 = Area.builder().id(10117405L).name("达江社区").father(fatherArea).area_level(4).risk_level(1).children(null).build();

        // setter - area101317 康安街道

        return new Area[]{area10117401, area10117402, area10117403, area10117404, area10117405};
    }

    /**
     * 爱建街道
     *
     * @return
     */
    private Area[] getAijianStreet(Area fatherArea) {
        // area101318 - 爱建街道 - area_level = 4
        Area area10118401 = Area.builder().id(10118401L).name("爱建社区").father(fatherArea).area_level(4).risk_level(1).children(null).build();
        Area area10118402 = Area.builder().id(10118402L).name("紫园社区").father(fatherArea).area_level(4).risk_level(1).children(null).build();
        Area area10118403 = Area.builder().id(10118403L).name("梧桐花园社区").father(fatherArea).area_level(4).risk_level(1).children(null).build();

        // setter - area101318 爱建街道

        return new Area[]{area10118401, area10118402, area10118403};
    }

    /**
     * 群力街道
     *
     * @return
     */
    private Area[] getQunliStreet(Area fatherArea) {
        // area101319 - 群力街道 - area_level = 4
        Area area10119401 = Area.builder().id(10119401L).name("康泰嘉园社区").father(fatherArea).area_level(4).risk_level(1).children(null).build();
        Area area10119402 = Area.builder().id(10119402L).name("城安社区").father(fatherArea).area_level(4).risk_level(1).children(null).build();
        Area area10119403 = Area.builder().id(10119403L).name("变兴路社区").father(fatherArea).area_level(4).risk_level(1).children(null).build();
        Area area10119404 = Area.builder().id(10119404L).name("汇锦庄园社区").father(fatherArea).area_level(4).risk_level(1).children(null).build();
        Area area10119405 = Area.builder().id(10119405L).name("珑岸社区").father(fatherArea).area_level(4).risk_level(1).children(null).build();
        Area area10119406 = Area.builder().id(10119406L).name("群力家园社区").father(fatherArea).area_level(4).risk_level(1).children(null).build();
        Area area10119407 = Area.builder().id(10119407L).name("恒大帝景社区").father(fatherArea).area_level(4).risk_level(1).children(null).build();
        Area area10119408 = Area.builder().id(10119408L).name("星光耀社区").father(fatherArea).area_level(4).risk_level(1).children(null).build();
        Area area10119409 = Area.builder().id(10119409L).name("恒祥空间社区").father(fatherArea).area_level(4).risk_level(1).children(null).build();
        Area area10119410 = Area.builder().id(10119410L).name("贝肯山社区").father(fatherArea).area_level(4).risk_level(1).children(null).build();
        Area area10119411 = Area.builder().id(10119411L).name("塞纳阳光社区").father(fatherArea).area_level(4).risk_level(1).children(null).build();
        Area area10119412 = Area.builder().id(10119412L).name("恒大雅苑社区").father(fatherArea).area_level(4).risk_level(1).children(null).build();
        Area area10119413 = Area.builder().id(10119413L).name("璞悦湾社区").father(fatherArea).area_level(4).risk_level(1).children(null).build();
        Area area10119414 = Area.builder().id(10119414L).name("保利社区").father(fatherArea).area_level(4).risk_level(1).children(null).build();
        Area area10119415 = Area.builder().id(10119415L).name("绿地社区").father(fatherArea).area_level(4).risk_level(1).children(null).build();
        Area area10119416 = Area.builder().id(10119416L).name("寰宇社区").father(fatherArea).area_level(4).risk_level(1).children(null).build();
        Area area10119417 = Area.builder().id(10119417L).name("翠湖社区").father(fatherArea).area_level(4).risk_level(1).children(null).build();
        Area area10119418 = Area.builder().id(10119418L).name("桐楠格领誉社区").father(fatherArea).area_level(4).risk_level(1).children(null).build();
        Area area10119419 = Area.builder().id(10119419L).name("融江路社区").father(fatherArea).area_level(4).risk_level(1).children(null).build();
        Area area10119420 = Area.builder().id(10119420L).name("金山村").father(fatherArea).area_level(4).risk_level(1).children(null).build();
        Area area10119421 = Area.builder().id(10119421L).name("友谊村").father(fatherArea).area_level(4).risk_level(1).children(null).build();
        Area area10119422 = Area.builder().id(10119422L).name("城西村").father(fatherArea).area_level(4).risk_level(1).children(null).build();
        Area area10119423 = Area.builder().id(10119423L).name("城乡村").father(fatherArea).area_level(4).risk_level(1).children(null).build();
        Area area10119424 = Area.builder().id(10119424L).name("松江村").father(fatherArea).area_level(4).risk_level(1).children(null).build();

        // setter - area101319 群力街道
        return new Area[]{area10119401, area10119402, area10119403, area10119404, area10119405, area10119406, area10119407, area10119408, area10119409, area10119410, area10119411, area10119412, area10119413, area10119414, area10119415, area10119416, area10119417, area10119418, area10119419, area10119420, area10119421, area10119422, area10119423, area10119424};
    }

    /**
     * 太平镇
     *
     * @return
     */
    private Area[] getTaipingTown(Area fatherArea) {
        // area101320 - 太平镇 - area_level = 4
        Area area10120401 = Area.builder().id(10120401L).name("太平社区").father(fatherArea).area_level(4).risk_level(1).children(null).build();
        Area area10120402 = Area.builder().id(10120402L).name("先富").father(fatherArea).area_level(4).risk_level(1).children(null).build();
        Area area10120403 = Area.builder().id(10120403L).name("立权").father(fatherArea).area_level(4).risk_level(1).children(null).build();
        Area area10120404 = Area.builder().id(10120404L).name("永和").father(fatherArea).area_level(4).risk_level(1).children(null).build();
        Area area10120405 = Area.builder().id(10120405L).name("先发").father(fatherArea).area_level(4).risk_level(1).children(null).build();
        Area area10120406 = Area.builder().id(10120406L).name("前进").father(fatherArea).area_level(4).risk_level(1).children(null).build();
        Area area10120407 = Area.builder().id(10120407L).name("立业").father(fatherArea).area_level(4).risk_level(1).children(null).build();
        Area area10120408 = Area.builder().id(10120408L).name("泰安").father(fatherArea).area_level(4).risk_level(1).children(null).build();
        Area area10120409 = Area.builder().id(10120409L).name("立功").father(fatherArea).area_level(4).risk_level(1).children(null).build();
        Area area10120410 = Area.builder().id(10120410L).name("太平").father(fatherArea).area_level(4).risk_level(1).children(null).build();

        // setter - area101320 太平镇
        return new Area[]{area10120401, area10120402, area10120403, area10120404, area10120405, area10120406, area10120407, area10120408, area10120409, area10120410};
    }

    /**
     * 新发镇
     *
     * @return
     */
    private Area[] getXinfaTown(Area fatherArea) {
        // area101321 - 新发镇 - area_level = 4
        Area area10121401 = Area.builder().id(10121401L).name("红旗村").father(fatherArea).area_level(4).risk_level(1).children(null).build();
        Area area10121402 = Area.builder().id(10121402L).name("先锋村").father(fatherArea).area_level(4).risk_level(1).children(null).build();
        Area area10121403 = Area.builder().id(10121403L).name("建国村").father(fatherArea).area_level(4).risk_level(1).children(null).build();
        Area area10121404 = Area.builder().id(10121404L).name("二场村").father(fatherArea).area_level(4).risk_level(1).children(null).build();
        Area area10121405 = Area.builder().id(10121405L).name("五一村").father(fatherArea).area_level(4).risk_level(1).children(null).build();
        Area area10121406 = Area.builder().id(10121406L).name("胜利村").father(fatherArea).area_level(4).risk_level(1).children(null).build();
        Area area10121407 = Area.builder().id(10121407L).name("五星村").father(fatherArea).area_level(4).risk_level(1).children(null).build();
        Area area10121408 = Area.builder().id(10121408L).name("新发村").father(fatherArea).area_level(4).risk_level(1).children(null).build();
        Area area10121409 = Area.builder().id(10121409L).name("向东村").father(fatherArea).area_level(4).risk_level(1).children(null).build();
        Area area10121410 = Area.builder().id(10121410L).name("庆丰村").father(fatherArea).area_level(4).risk_level(1).children(null).build();
        Area area10121411 = Area.builder().id(10121411L).name("三场村").father(fatherArea).area_level(4).risk_level(1).children(null).build();
        Area area10121412 = Area.builder().id(10121412L).name("东明村").father(fatherArea).area_level(4).risk_level(1).children(null).build();

        // setter - area101321 新发镇
        return new Area[]{area10121401, area10121402, area10121403, area10121404, area10121405, area10121406, area10121407, area10121408, area10121409, area10121410, area10121411, area10121412};
    }

    /**
     * 新农镇
     *
     * @return
     */
    private Area[] getXinongTown(Area fatherArea) {
        // area101322 - 新农镇 - area_level = 4
        Area area10122401 = Area.builder().id(10122401L).name("闫家岗社区").father(fatherArea).area_level(4).risk_level(1).children(null).build();
        Area area10122402 = Area.builder().id(10122402L).name("新农社区").father(fatherArea).area_level(4).risk_level(1).children(null).build();
        Area area10122403 = Area.builder().id(10122403L).name("万家").father(fatherArea).area_level(4).risk_level(1).children(null).build();
        Area area10122404 = Area.builder().id(10122404L).name("新农").father(fatherArea).area_level(4).risk_level(1).children(null).build();
        Area area10122405 = Area.builder().id(10122405L).name("前进").father(fatherArea).area_level(4).risk_level(1).children(null).build();
        Area area10122406 = Area.builder().id(10122406L).name("新江").father(fatherArea).area_level(4).risk_level(1).children(null).build();
        Area area10122407 = Area.builder().id(10122407L).name("团结").father(fatherArea).area_level(4).risk_level(1).children(null).build();
        Area area10122408 = Area.builder().id(10122408L).name("一场").father(fatherArea).area_level(4).risk_level(1).children(null).build();
        Area area10122409 = Area.builder().id(10122409L).name("和平").father(fatherArea).area_level(4).risk_level(1).children(null).build();
        Area area10122410 = Area.builder().id(10122410L).name("新兴").father(fatherArea).area_level(4).risk_level(1).children(null).build();
        Area area10122411 = Area.builder().id(10122411L).name("新立").father(fatherArea).area_level(4).risk_level(1).children(null).build();
        Area area10122412 = Area.builder().id(10122412L).name("闫家岗").father(fatherArea).area_level(4).risk_level(1).children(null).build();

        // setter - area101322 新农镇
        return new Area[]{area10122401, area10122402, area10122403, area10122404, area10122405, area10122406, area10122407, area10122408, area10122409, area10122410, area10122411, area10122412};
    }

    /**
     * 榆树镇
     *
     * @return
     */
    private Area[] getYushuTown(Area fatherArea) {
        // area101323 - 榆树镇 - area_level = 4
        Area area10123401 = Area.builder().id(10123401L).name("新榆社区").father(fatherArea).area_level(4).risk_level(1).children(null).build();
        Area area10123402 = Area.builder().id(10123402L).name("后榆社区").father(fatherArea).area_level(4).risk_level(1).children(null).build();
        Area area10123403 = Area.builder().id(10123403L).name("新乡村").father(fatherArea).area_level(4).risk_level(1).children(null).build();
        Area area10123404 = Area.builder().id(10123404L).name("三姓村").father(fatherArea).area_level(4).risk_level(1).children(null).build();
        Area area10123405 = Area.builder().id(10123405L).name("民主村").father(fatherArea).area_level(4).risk_level(1).children(null).build();
        Area area10123406 = Area.builder().id(10123406L).name("民泉村").father(fatherArea).area_level(4).risk_level(1).children(null).build();
        Area area10123407 = Area.builder().id(10123407L).name("五四村").father(fatherArea).area_level(4).risk_level(1).children(null).build();
        Area area10123408 = Area.builder().id(10123408L).name("望哈村").father(fatherArea).area_level(4).risk_level(1).children(null).build();

        // setter - area101323 榆树镇
        return new Area[]{area10123401, area10123402, area10123403, area10123404, area10123405, area10123406, area10123407, area10123408};
    }

    /**
     * 新发街道
     *
     * @return
     */
    private Area[] getXinfaStreet(Area fatherArea) {
        // area101324 - 新发街道 - area_level = 4
        Area area10124401 = Area.builder().id(10124401L).name("民生尚都社区").father(fatherArea).area_level(4).risk_level(1).children(null).build();
        Area area10124402 = Area.builder().id(10124402L).name("祥园社区").father(fatherArea).area_level(4).risk_level(1).children(null).build();
        Area area10124403 = Area.builder().id(10124403L).name("和园社区").father(fatherArea).area_level(4).risk_level(1).children(null).build();
        Area area10124404 = Area.builder().id(10124404L).name("红旗社区").father(fatherArea).area_level(4).risk_level(1).children(null).build();
        Area area10124405 = Area.builder().id(10124405L).name("新发社区").father(fatherArea).area_level(4).risk_level(1).children(null).build();
        Area area10124406 = Area.builder().id(10124406L).name("馨园社区").father(fatherArea).area_level(4).risk_level(1).children(null).build();
        Area area10124407 = Area.builder().id(10124407L).name("福园社区").father(fatherArea).area_level(4).risk_level(1).children(null).build();
        Area area10124408 = Area.builder().id(10124408L).name("富田社区").father(fatherArea).area_level(4).risk_level(1).children(null).build();
        
        return new Area[]{area10124401, area10124402, area10124403, area10124404, area10124405, area10124406, area10124407, area10124408};

    }


}
