def best_foot_outlet(city, votes):
  base_url = "https://jsonmock.hackerrank.com/api/food_outlets?"
      page_num = 1
      best_outlet = None
  
      while True:
          url = f"{base_url}city={city}&page={page_num}"
          response = requests.get(url)
          data = response.json()
  
          if 'data' not in data or not data['data']:
              break
  
          outlets = data['data']
  
          for outlet in outlets:
              if 'user_rating' in outlet:
                  user_rating = outlet['user_rating']
                  if user_rating['votes'] >= votes:
                      if best_outlet is None or (user_rating['average_rating'], user_rating['votes']) > (best_outlet['user_rating']['average_rating'], best_outlet['user_rating']['votes']):
                          best_outlet = outlet
  
          page_num += 1
  
      return best_outlet
