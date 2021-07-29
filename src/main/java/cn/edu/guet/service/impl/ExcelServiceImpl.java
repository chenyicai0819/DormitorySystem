package cn.edu.guet.service.impl;



import cn.edu.guet.bean.ReturnInfoUtil;
import cn.edu.guet.bean.ReturnUtil;
import cn.edu.guet.bean.Student;
import cn.edu.guet.mapper.ExcelDao;
import cn.edu.guet.service.ExcelService;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * @author George
 * @project excdemo
 * @package com.example.excdemo.service.impl
 * @date 2021/7/24 19:50
 * @since 1.0
 */
@Service
public class ExcelServiceImpl implements ExcelService {

    @Autowired
    private ExcelDao excelDao;

    /**
     *
     * @param fileName
     * @param file
     * @return
     * @throws Exception
     */
    @Override
    public ReturnInfoUtil getExcelInfo(String fileName, MultipartFile file) throws Exception {
        ReturnInfoUtil returnInfoUtil = new ReturnInfoUtil();
        int[] resultCell = new int[]{0,1,2,3,4,5,6,7};//要将表中的哪几列传入数据库中，从0开始计数
        List<Student> resultList = new ArrayList<>();
        if (!fileName.matches("^.+\\.(?i)(xls)$") && !fileName.matches("^.+\\.(?i)(xlsx)$")) {
            return ReturnUtil.error("上传文件格式不正确");
        }
        boolean isExcel2003 = true;
        if (fileName.matches("^.+\\.(?i)(xlsx)$")) {
            isExcel2003 = false;
        }
        InputStream is = file.getInputStream();
        Workbook wb = null;
        if (isExcel2003) {
            wb = new HSSFWorkbook(is);
        } else {
            wb = new XSSFWorkbook(is);
        }
        Sheet sheet = wb.getSheetAt(0);
        resultList = getSheetVal(sheet, resultCell);
        System.out.println("结果集---"+resultList);
        try{
            excelDao.addUser(resultList);
            returnInfoUtil = ReturnUtil.success("");
        }catch (Exception e){
            e.printStackTrace();
            returnInfoUtil = ReturnUtil.error("数据导入失败");
        }
        return returnInfoUtil;
    }

    /**
     *
     * @param sheet
     * @param resultCell 需要将哪些列插入至数据库
     * @return
     */
    public List getSheetVal(Sheet sheet, int[] resultCell){
        List<Student> bankList = new ArrayList<>();//返回的结果集
        int[] resultIndex = new int[resultCell.length];//存储需要上传字段的下标
        Student bank;
        for (int r = 1; r <= sheet.getLastRowNum(); r++) {
            Row row = sheet.getRow(r);
            if (row == null) {
                continue;
            }
            bank = new Student();
            for (int i = 0;i<row.getPhysicalNumberOfCells();i++){
                String temp = getCellVal(row.getCell(i)).toString().trim();
                for (int j=0;j<resultCell.length;j++){
                    if (i==resultCell[j]){
                        switch (i){
                            case 0:
                                System.out.println(temp);
                                bank.setsId(Integer.parseInt(temp));
                                break;
                            case 1:
                                System.out.println(temp);
                                bank.setRoleId(temp);
                                break;
                            case 2:
                                System.out.println(temp);
                                bank.setsPwd(temp);
                                break;
                            case 3:
                                System.out.println(temp);
                                bank.setsName(temp);
                                break;
                            case 4:
                                System.out.println(temp);
                                bank.setsSex(temp);
                                break;
                            case 5:
                                System.out.println(temp);
                                bank.setsCollege(temp);
                                break;
                            case 6:
                                System.out.println(temp);
                                bank.setsGrade(temp);
                                break;
                            case 7:
                                System.out.println(temp);
                                bank.setsPhone(temp);
                                break;
                            default:
                                break;
                        }
                    }else{
                        continue;
                    }
                }
            }
            bankList.add(bank);
        }
        return bankList;
    }

    /**
     *
     * @param cell
     * @return
     */
    public Object getCellVal(Cell cell){
        Object obj = null;
        switch (cell.getCellTypeEnum()) {
            case BOOLEAN:
                obj = cell.getBooleanCellValue();
                break;
            case ERROR:
                obj = cell.getErrorCellValue();
                break;
            case NUMERIC:
                obj = cell.getNumericCellValue();
                break;
            case STRING:
                obj = cell.getStringCellValue();
                break;
            default:
                break;
        }
        return obj;
    }
}
