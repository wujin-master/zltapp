//package com.zlt.controller;
//
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
////异常类使用说明
//public class demo {
//
//    返回类型为Result
//    //成功返回且不携带数据---Result.success()
//    //成功返回且携带数据---Object obj[] = {1个，第2个};Result.success(obj);
//    //失败不返回数据----Result.failure(ResultCode.跟上在ResultCode里面定义好的常量)
//    //使用getUUID()设置Id示例
//        //course.setCourseId(UUIDUtil.getUUID());
//    @PostMapping("/addCourse")
//    @ResponseBody
//    public Result addCourse(@RequestBody Course course){
//        //使用getUUID()设置Id示例
//        course.setCourseId(UUIDUtil.getUUID());
//        int result = courseService.addCourse(course);
//        if(result != 1)
//            return Result.failure(ResultCode.COURSE_INSERT_FAILED);
//        else
//            return Result.success();
//    }
//
//    @GetMapping("show_class")
//    public Result showClass(String page, String limit, Integer teacherId){
//        //每页查询条数
//        int pageLimit = Integer.valueOf(limit);
//        //从第startIndex条开始查询
//        int startIndex = pageLimit * (Integer.valueOf(page) - 1);
//        List<Classes> classList = classesService.selAll(startIndex,pageLimit,teacherId);
//        //查询到的班级总数
//        int count = classList.size();
//        //封装需要返回的数据
//        List<ClassesVO> classVOList = Classes2ClassVO.convert(classList);
//        int number = 0;
//        for(ClassesVO classesVO:classVOList){
//            //班级人数
//            number = studentClassService.selByCI(classesVO.getClassId()).size();
//            classesVO.setNumber(number);
//        }
//        //求班级人数
////        List<Integer> classIds = classList.stream().map(e->e.getClassId())
////                .collect(Collectors.toList());
//        Object obj[] = {classVOList,count};
//        return Result.success(obj);
//    }
//
//    @RequestMapping(value = "/getCourseByNameMaster", method={RequestMethod.GET})
//    public Result getCourseByNameMaster(@RequestParam("courseName") String courseName,
//                                        @RequestParam("courseMaster") String courseMaster){
//        Course course = courseService.getCourseByNameMaster(courseName,courseMaster);
//        return Result.success(course);
//    }
//}
