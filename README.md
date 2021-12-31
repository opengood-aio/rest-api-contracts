# REST API Contracts

[![Build](https://github.com/opengoodio/rest-api-contracts/workflows/build/badge.svg)](https://github.com/opengoodio/rest-api-contracts/actions?query=workflow%3Abuild)
[![Release](https://github.com/opengoodio/rest-api-contracts/workflows/release/badge.svg)](https://github.com/opengoodio/rest-api-contracts/actions?query=workflow%3Arelease)
[![Codecov](https://codecov.io/gh/opengoodio/rest-api-contracts/branch/main/graph/badge.svg?token=AEEYTGK87F)](https://codecov.io/gh/opengoodio/rest-api-contracts)
[![Release Version](https://img.shields.io/github/release/opengoodio/rest-api-contracts.svg)](https://github.com/opengoodio/rest-api-contracts/releases/latest)
[![Maven Central](https://maven-badges.herokuapp.com/maven-central/io.opengood.api/rest-api-contracts/badge.svg)](https://maven-badges.herokuapp.com/maven-central/io.opengood.api/rest-api-contracts)
[![License](https://img.shields.io/badge/license-MIT-blue.svg)](https://raw.githubusercontent.com/opengoodio/rest-api-contracts/master/LICENSE)
[![FOSSA](https://app.fossa.com/api/projects/custom%2B22161%2Fgithub.com%2Fopengoodio%2Frest-api-contracts.svg?type=small)](https://app.fossa.com/projects/custom%2B22161%2Fgithub.com%2Fopengoodio%2Frest-api-contracts?ref=badge_small)

Reusable REST API contracts

## Setup

### Add Dependency

#### Gradle

```groovy
implementation("io.opengood.api:rest-api-contracts:VERSION")
```

#### Maven

```xml
<dependency>
    <groupId>io.opengood.api</groupId>
    <artifactId>rest-api-contracts</artifactId>
    <version>VERSION</version>
</dependency>
```

**Note:** See *Release* version badge above for latest version.

## Features

### `DeleteDataRequest`

Data contract for deleting data by unique identifier.

Data in JSON format:

* `name`: Name of the data object type in data repository
* `id`: Unique identifier of a data object to delete from data
repository

#### Example

```json
{
    "name": "products",
    "id": "82a94d9f-894c-4c00-ba40-a36e8f55f842"
}
```

#### `ActionResponse`

Data contract containing action response for `DeleteDataRequest`.

Other contracts used:

* `OperationState`

Data in JSON format:

* `state`: State of request `SUCCESS` or `FAILED`
* `message`: Textual message providing context for response

##### Example

```json
{
    "state": "SUCCESS",
    "message": "Data deleted"
}
```

---

### `GetDataByIdRequest`

Data contract for retrieving data by unique identifier.

Data in JSON format:

* `name`: Name of the data object type in data repository
* `id`: Unique identifier of a data object to retrieve from data
repository

#### Example

```json
{
    "name": "products",
    "id": "82a94d9f-894c-4c00-ba40-a36e8f55f842"
}
```

#### `DataByIdResponse`

Data contract containing data response for `GetDataByIdRequest`.

Other contracts used:

* `OperationState`

Data in JSON format:

* `state`: State of request `SUCCESS` or `FAILED`
* `message`: Textual message providing context for response
* `data`: Map of key/value pairs representing row of data retrieved from
data repository

##### Example

```json
{
    "state": "SUCCESS",
    "message": "Data retrieved",
    "data": {
        "product_id": 1,
        "name": "Product 1"
    }
}
```

---

### `GetDataRequest`

Data contract for retrieving data. Includes filtering, paging, and
sorting.

Other contracts used:

* `FilterRequest`
* `FilterParameter`
* `FilterType`
* `PageRequest`
* `SortRequest`
* `SortParameter`
* `SortDirection`

Data in JSON format:

* `name`: Name of the data object type in data repository
* `filter`: List of parameters representing fields, values, and types
  in which to filter data from data repository
  * `params`: Filtering parameters in which to filter data
    * `name`: Name of field in which to filter data
    * `value`: Filter value for field
    * `type`: Filter type for field
      * `EQUALS` performs equality filter on field
      * `CONTAINS` performs contains filter on field
    * `condition`: Filter condition for field
      * `AND` creates an and condition for field
      * `OR` creates an or condition for field
* `page`: Pagination parameters in which to retrieve a page of data
  * `index`: Current index of page of data to retrieve
  * `size`: Number of rows of data per page to retrieve
* `sort`: List of parameters representing fields and direction in
  which to sort data from data repository
  * `params`: Sorting parameters in which to sort data
    * `name`: Name of field in which to sort data
    * `direction`: Sort direction of field
      * `ASC` sorts field in ascending order
      * `DESC` sorts field in descending order

##### Example

```json
{
    "name": "products",
    "filter": {
        "params": [
            {
                "name": "product_name",
                "value": "Product",
                "type": "CONTAINS",
                "condition": "AND"
            }
        ]
    },
    "page": {
        "index": 0,
        "size": 2
    },
    "sort": {
        "params": [
            {
                "name": "product_name",
                "direction": "ASC"
            }
        ]
    }
}
```

#### `DataResponse`

Data contract containing data response for `GetDataRequest`.
Includes page and record data.

Other contracts used:

* `OperationState`
* `PageData`
* `PageState`
* `RecordData`

Data in JSON format:

* `state`: State of request `SUCCESS` or `FAILED`
* `message`: Textual message providing context for response
* `pages`: Object containing information about page data
  * `state`: State of page `NONE` or `PAGINATED`
  * `index`: Current index of page of data retrieved
  * `size`: Number of rows of data in current page retrieved
  * `count`: Total number of pages in dataset
* `records`: Object containing information about record data
  * `total`: Total number of records in dataset
* `data`: Array containing map of key/value pairs representing row(s) of
  data retrieved from data repository

##### Example

```json
{
    "state": "SUCCESS",
    "message": "Data retrieved",
    "pages": {
        "state": "PAGINATED",
        "index": 0,
        "size": 2,
        "count": 1
    },
    "records": {
        "total": 2
    },
    "data": [
        {
            "product_id": 1,
            "name": "Product 1"
        },
        {
            "product_id": 2,
            "name": "Product 2"
        }
    ]
}
```

---

### `SaveDataRequest`

Data contract for saving data.

Data in JSON format:

* `name`: Name of the data object type in data repository
* `data`: Array containing map of key/value pairs representing row(s) of
  data to save to data repository

##### Example

```json
{
    "name": "products",
    "data": [
        {
            "name": "Product 1"
        },
        {
            "name": "Product 2"
        }
    ]
}
```

#### `ActionResponse`

Data contract containing action response for `SaveDataRequest`.

Other contracts used:

* `OperationState`

Data in JSON format:

* `state`: State of request `SUCCESS` or `FAILED`
* `message`: Textual message providing context for response
* `data`: Array containing map of key/value pairs with generated unique
  identifier(s) representing row(s) of data saved to data repository

##### Example

```json
{
    "state": "SUCCESS",
    "message": "Data saved",
    "data": [
        {
            "product_id": 1,
            "name": "Product 1"
        },
        {
            "product_id": 2,
            "name": "Product 2"
        }
    ]
}
```
