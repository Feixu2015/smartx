/**
 *
 * http://www.idcos.com
 * Copyright (c) 2018 All Rights Reserved.
 */
package org.feixu.smartx.poi

import org.apache.poi.ss.usermodel.Cell
import org.apache.poi.ss.usermodel.CellStyle
import org.apache.poi.ss.usermodel.HorizontalAlignment
import org.apache.poi.ss.usermodel.Row
import org.apache.poi.ss.usermodel.Sheet
import org.apache.poi.ss.usermodel.VerticalAlignment
import org.apache.poi.ss.usermodel.Workbook
import org.apache.poi.ss.util.CellRangeAddress
import org.apache.poi.xssf.usermodel.XSSFWorkbook
import org.junit.Test
/**
 * Excel Uitl
 *
 * @author Feixu
 * @version $Id: ExcelUtilTest.java, v 0.1 2018/3/21 Feixu Exp $
 */
class ExcelUtilTest {
    @Test
    void mergeCell(){
        Workbook wb = new XSSFWorkbook()
        Sheet sheet = wb.createSheet("new sheet")

        Row row = sheet.createRow(0)
        // (0,0) (1,0)单元格合并
        Cell cell = row.createCell(0)
        cell.setCellValue("This is a test of merging")

        sheet.addMergedRegion(new CellRangeAddress(
                0, //first row (0-based)
                1, //last row  (0-based)
                0, //first column (0-based)
                0  //last column  (0-based)
        ))
        // (0,0) (1,0)单元格居中设置
        CellStyle style = wb.createCellStyle()
        style.setAlignment(HorizontalAlignment.CENTER)
        style.setVerticalAlignment(VerticalAlignment.CENTER)
        cell.setCellStyle(style)

        // create title 1
        String[] title1 = ['col11', 'col12']
        for (int i = 0; i < title1.length; i++) {
            row.createCell(i + 1).setCellValue("1"+ (i+1))
        }
        // create title 2
        Row row1 = sheet.createRow(1)
        String[] title2 = ['col21', 'col22']
        for (int i = 0; i < title2.length; i++) {
            row1.createCell(i + 1).setCellValue("2" + (i+1))
        }

        // Write the output to a file
        FileOutputStream fileOut = new FileOutputStream("workbook.xlsx")
        wb.write(fileOut)
        fileOut.close()
    }
}
