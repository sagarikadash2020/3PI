Set objShell = CreateObject("WScript.Shell")

Sub ExcelMacroExample()

Set objExcel = CreateObject("Excel.Application")
Set objWorkbook = objExcel.Workbooks.Open("C:\Users\moneecasinha\Downloads\IPM v9-2-03.xlsm")
objExcel.Run "Import Inputs"
objExcel.Save
objExcel.Quit 

End Sub