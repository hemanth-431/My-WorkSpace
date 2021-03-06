import 'package:flutter/material.dart';
import 'package:flutter/widgets.dart';
import '../model/container.dart';
import 'package:intl/intl.dart';
class TransactionList extends StatelessWidget
{

final List<container> transactions;
TransactionList(this.transactions);
  @override
  Widget build(BuildContext context) {
    // TODO: implement build

    return   Container(
      height: 400,

      child: ListView.builder(
       itemBuilder: (ctx,index){
         return Card(child: Row(children:<Widget>[Container(
           margin: EdgeInsets.symmetric(vertical:10,horizontal:15),
           decoration: BoxDecoration(border: Border.all(color:Theme.of(context).primaryColorLight,width: 2,),),
           padding: EdgeInsets.all(10),
           child:Text('\$${transactions[index].amount.toStringAsFixed(2)}',
             style: TextStyle(fontWeight: FontWeight.bold,fontSize: 20,color: Colors.purple,),

           ),),
           Column(
             crossAxisAlignment: CrossAxisAlignment.start,
             children: <Widget>[

               Text(transactions[index].title,style: TextStyle(fontSize: 16,fontWeight:FontWeight.bold,color: Colors.deepOrange),),//style: Theme.of(context).textTheme.tiltle,
               Text(DateFormat.yMMMd(). format(transactions[index].date),style: TextStyle(fontSize: 13,fontStyle: FontStyle.italic,fontWeight: FontWeight.bold,color: Colors.blue),),


             ],),],),
         );
       },
        itemCount: transactions.length,



      ),
    );
  }

}