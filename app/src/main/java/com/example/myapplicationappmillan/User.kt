package com.example.myapplicationappmillan

data class User( var client:String, var id:Int, var item:String, var order_process: String,
                 var payment_name:String, var phone_numberCli:Int, var emailCli:String , var addressCli:String, var nitCLi:Int,
                 var surface_finish:String, var tolerance:Int,var linear:Int,var angular:Int,var size:Int,var volume:Int,
                 var quote_number:Int,
                 var subtotal:Int,var freigth:Int,var various_expenses:Int,var amount_whitout_vat:Int,var total_amount:Int,var delivery_address:String,
                 var pic: String)