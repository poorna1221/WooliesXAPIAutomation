$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("WeatherAPI.feature");
formatter.feature({
  "line": 1,
  "name": "Weather forecast of sydney on thursdays",
  "description": "",
  "id": "weather-forecast-of-sydney-on-thursdays",
  "keyword": "Feature"
});
formatter.scenario({
  "line": 5,
  "name": "A happy holidaymaker",
  "description": "",
  "id": "weather-forecast-of-sydney-on-thursdays;a-happy-holidaymaker",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 3,
      "name": "@smoketest"
    }
  ]
});
formatter.step({
  "line": 7,
  "name": "I like to holiday in Sydney",
  "keyword": "Given "
});
formatter.step({
  "line": 8,
  "name": "I only like to holiday on Thursdays",
  "keyword": "And "
});
formatter.step({
  "line": 9,
  "name": "I look up the weather forecast",
  "keyword": "When "
});
formatter.step({
  "line": 10,
  "name": "I receive the weather forecast",
  "keyword": "Then "
});
formatter.step({
  "line": 11,
  "name": "the temperature is warmer than 10 degrees",
  "keyword": "And "
});
formatter.match({
  "location": "WeatherForecast.i_like_to_holiday_in_Sydney()"
});
formatter.result({
  "duration": 5106727013,
  "status": "passed"
});
formatter.match({
  "location": "WeatherForecast.i_only_like_to_holiday_on_Thursdays()"
});
formatter.result({
  "duration": 48551,
  "status": "passed"
});
formatter.match({
  "location": "WeatherForecast.i_look_up_the_weather_forecast()"
});
formatter.result({
  "duration": 57236,
  "status": "passed"
});
formatter.match({
  "location": "WeatherForecast.i_receive_the_weather_forecast()"
});
formatter.result({
  "duration": 49341,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "10",
      "offset": 31
    }
  ],
  "location": "WeatherForecast.the_temperature_is_warmer_than_degrees(int)"
});
formatter.result({
  "duration": 4747774,
  "status": "passed"
});
});