import 'package:flutter/material.dart';
import 'package:flutter/widgets.dart';
import 'package:intl/intl.dart';

import '../models/transaction.dart';

class TransactionList extends StatelessWidget {
  final List<Transaction> transactions;

  TransactionList(this.transactions);

  @override
  Widget build(BuildContext context) {
    return Container(
      height: 300,
      child: transactions.isEmpty ? Column(children: <Widget>[
        Text('No Transactions Published at!',style: Theme.of(context).textTheme.title,),SizedBox(height: 20,),
        Container(child: Image.asset('assets/images/kunfu1.jpg',fit: BoxFit.cover,)),

      ],): ListView.builder(
        itemBuilder: (ctx, index) {
         return Card(
           margin: EdgeInsets.symmetric(vertical: 8,horizontal: 5),
           child:
             ListTile(leading: CircleAvatar(radius: 30,child:Padding(
               padding: const EdgeInsets.all(6.0),
               child: FittedBox(child: Text('\$${transactions[index].amount}'),),
             ),
             ),
             title: Text(transactions[index].title,style: Theme.of(context).textTheme.title,),
               subtitle: Text(DateFormat.yMMMd().format(transactions[index].date),),

             ),

         );

        },
        itemCount: transactions.length,
      ),
    );
  }
}

