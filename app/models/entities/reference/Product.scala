package models.entities.reference

import play.api.libs.json.Json
import utils.RestJsonFormatExt

/**
  * Created by adildramdan on 11/17/17.
  */
case class Product(id           : Option[Long]  = None,
                   name         : String,
                   description  : String,
                   qty          : Int)


object Product extends RestJsonFormatExt{
  implicit val productJsonFormat  = Json.format[Product]
}