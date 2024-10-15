import 'package:cached_network_image/cached_network_image.dart';
import 'package:flutter/material.dart';
import 'package:flutter_spinkit/flutter_spinkit.dart';
import 'package:sdaassignmenttwo/model/news_model.dart';

import '../view_model/news_view_model.dart';
class NewsScreen extends StatefulWidget {
  const NewsScreen({super.key});

  @override
  State<NewsScreen> createState() => _NewsScreenState();
}

class _NewsScreenState extends State<NewsScreen> {
  NewsDataViewModel newsDataViewModel=NewsDataViewModel();
  @override
  Widget build(BuildContext context) {
    return   Scaffold(
      appBar: AppBar()
          ,
      body: FutureBuilder<NewsModel>(
        future: newsDataViewModel.fetchNewsData(),
        builder: (BuildContext context,
            AsyncSnapshot<NewsModel> snapshot) {
          if(snapshot.connectionState==ConnectionState.waiting){
            return Center(
              child: SpinKitFoldingCube(
                color: Colors.black,
              ),
            );
          }
          else{
            return ListView.builder(
                itemCount: snapshot.data!.articles!.length,
                itemBuilder: (context,index){
                  var title = snapshot
                      .data!.articles![index].title
                      .toString();
                  var img = snapshot
                      .data!.articles![index].urlToImage
                      .toString();
                  var source = snapshot
                      .data!.articles![index].author
                      .toString();
                  var description = snapshot
                      .data!.articles![index].description
                      .toString();
                  return Container(
                    child: Padding(
                      padding: const EdgeInsets.all(8.0),
                      child: Column(
                        children: [
                          CachedNetworkImage(
                            imageUrl: img,
                            fit: BoxFit.fill,
                            placeholder: (context, url) =>
                            const SpinKitCubeGrid(
                              size: 30,
                              color: Colors.cyan,
                            ),
                            errorWidget: (context, url, error) =>
                            const Icon(
                              Icons.error,
                              color: Colors.red,
                            ),
                          ),
                          SizedBox(
                            height: 5,
                          ),
                          Text(title,
                            maxLines: 3,), SizedBox(
                            height: 5,
                          ),
                          Text(source),
                          SizedBox(
                            height: 5,
                          ),
                          Text(description)


                        ],
                      ),
                    ),
                  );
                }) ;
          }

       },

      ),
    );
  }
}
