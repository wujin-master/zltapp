package com.zlt.utils;

public enum ResultCode {
    SUCCESS(0,"成功"),
    PARAM_ERROR(-1,"参数不正确"),

    //成功返回的不需要再写结果码，默认时SUCCESS
    //失败结果返回码再后面添加，且注意最后一个需要以分号结尾，其余以逗号结束
    //比如插入失败，删除失败，查询失败等等，以便前端知晓错误原因
//    COURSE_INSERT_FAILED(1000,"课程插入失败"),
//    COURSE_DELETE_FAILED(1001,"课程删除失败"),
    //规定一下范围：任务选择1同学结果码范围为1000-1499，任务2为1501-1999，任务3为2000-2499,任务4为2500-2999
    //前面两个有关课程的是示例，大家可以注释掉，最上面两个是通用的
    LOGIN_PASSWORD_ERROR(1000,"登录密码错误"),
    USERNAME_NOT_EXIST(1001,"手机号或邮箱不存在"),
    REGISTER_EMAIL_HAS_EXIST(1002,"邮箱已存在"),
    REGISTER_MOBILE_HAS_EXIST(1003,"手机号已存在"),
    USER_NOT_EXIST(1004,"用户不存在"),
    USER_DELETE_ERROR(1005,"用户删除失败"),
    USER_UPDATE_ERROR(1006,"用户更新失败"),

    SET_EXAM_FAILED(1010,"设置考试失败"),

    SINGLE_INSERT_FAILED(1011,"单选题添加失败"),
    MULTI_INSERT_FAILED(1012,"多选题添加失败"),
    TORF_INSERT_FAILED(1013,"判断题添加失败"),

    PAPER_CREATE_FAILED(1014,"试卷生成失败"),

    TASK_CREATE_FAILED(1015,"作业生成失败"),
    SET_TASK_FAILED(1016,"作业发布失败"),

    CLASS_BATCHDELETE_FAILED(1017,"班级批量删除失败"),
    CLASS_DELETE_FAILED(1018,"班级删除失败"),

    ADD_CLASS_FAILED(1019,"班级添加失败"),
    SET_PORTRAIT_FAILED(1020,"头像设置失败"),
    SCORE_UPDATE_FAILED(1021,"分数修改失败"),

    TEACHER_DELETE_FAILED(1022,"教师删除失败"),
    TEACHER_UPDATE_FAILED(1023,"教师更新失败"),
    TEACHER_ADD_FAILED(1024,"教师添加失败"),
    TEACHER_FIND_FAILED(1025,"教师信息查找失败"),

    TEACHEREXAM_DELETE_FAILED(1026,"教师考试删除失败"),
    TEACHEREXAM_UPDATE_FAILED(1027,"教师考试更新失败"),
    TEACHEREXAM_ADD_FAILED(1028,"教师考试添加失败"),
    TEACHEREXAM_FIND_FAILED(1029,"教师考试信息查找失败"),

    TEACHERTASK_DELETE_FAILED(1030,"教师作业删除失败"),
    TEACHERTASK_UPDATE_FAILED(1031,"教师作业更新失败"),
    TEACHERTASK_ADD_FAILED(1032,"教师作业添加失败"),
    TEACHERTASK_FIND_FAILED(1033,"教师作业信息查找失败"),

    TASK_DELETE_FAILED(1034,"教师删除失败"),
    TASK_UPDATE_FAILED(1035,"教师更新失败"),
    TASK_ADD_FAILED(1036,"教师添加失败"),
    TASK_FIND_FAILED(1037,"教师信息查找失败"),

    EXAM_DELETE_FAILED(1038,"教师删除失败"),
    EXAM_UPDATE_FAILED(1039,"教师更新失败"),
    EXAM_ADD_FAILED(1040,"教师添加失败"),
    EXAM_FIND_FAILED(1041,"教师信息查找失败"),




    ID_HAS_EXIST(2001,"ID已存在");

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    private Integer code;
    private String msg;
    ResultCode(Integer code,String msg){
        this.code = code;
        this.msg = msg;
    }
}
