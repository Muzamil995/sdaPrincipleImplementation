import 'dart:convert';


import 'package:http/http.dart' as http;

import '../model/news_model.dart';

class NewsDataViewModel {
  String uri =
      "https://newsapi.org/v2/top-headlines?sources=bbc-news&apiKey=98dee3928461470d8f4fcbbfbc664f4a";

  Future<NewsModel> fetchNewsData() async {
    final response = await http.get(Uri.parse(uri));

    if (response.statusCode == 200) {
      final body = jsonDecode(response.body);
      return NewsModel.fromJson(body);
    }
    throw Exception("errror");
  }
}
