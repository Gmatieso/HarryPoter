# HarryPoter

Android App that uses Retrofit and Jetpack Compose to easily consume a HarryPotter API and display information about characters. The app allows users to browse a list of characters and view detailed information about each one. The app has a clean, intuitive user interface built with Jetpack Compose, making it easy to use and navigate.

## Libraries

- Retrofit2
- Coil
- Compose Navigation
- Hilt Navigation
- LiveData
- ViewModel
- Dagger Hilt

## Features/Stories

- Show a list of characters
- See the details of character
- Search for a specific character by name or house 
- Unit Test that checks if API intergration is Working Properly


## API Reference

#### Live HarryPotter list

```http
  GET https://hp-api.onrender.com/api/characters/
```

| Base Url                           | Parameter    | Type     |
|:-----------------------------------|:-------------|:---------|
| `https://hp-api.onrender.com/api/` | `characters` | `string` |

#### Search for a specific character by name or house


```http
  GET https://hp-api.onrender.com/api/characters/house/gryffindor
```

| Base Url                           | Parameter      | Type     | Description          |
|:-----------------------------------|:---------------|:---------|:---------------------|
| `https://hp-api.onrender.com/api/` | `house/:house` | `string` | **Required**.  house |

## Documentation

[Documentation](https://hp-api.onrender.com/)

![App Screenshot]
![img.png](img.png)
![img_1.png](img_1.png)
![img_2.png](img_2.png)

