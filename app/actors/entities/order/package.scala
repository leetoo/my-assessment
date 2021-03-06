package actors.entities

import actors.Command
import actors.entities.cart.Item
import models.entities.order.{OrderCoupon, OrderInformation, OrderShipment, Payment}

package object order{

  case class Submit(orderId: String, userId: String, coupon: Option[String], payment: Payment, info: OrderInformation) extends Command
  case class RequestVerification(orderId: String, paymentProof: String) extends Command
  case class Verify(orderId: String) extends Command
  case class RequestShipment(orderId: String, shipment: OrderShipment) extends Command
  case class Finish(orderId: String) extends Command
  case class Cancel(orderId: String) extends Command

  sealed trait Event
  case class Submitted(orderId: String, userId: String, items : List[Item], coupon: Option[OrderCoupon], payment: Payment, info: OrderInformation, status: String) extends Event
  case class ResponseVerification(orderId: String, paymentProof: String, status: String)  extends Event
  case class Verified(orderId: String, status: String) extends Event
  case class Shipped(orderId: String, shipment: OrderShipment, shipmentId: String, status: String) extends Event
  case class Finished(orderId: String, status: String) extends Event
  case class Canceled(orderId: String, status: String) extends Event


  sealed trait Query
  case object  GetOrder extends Query
  case class  GetOrderById(orderId: String) extends Query
  case class  GetOrderByShippingId(shippingId: String) extends Query
  case class  GetOrderByUser(userId: String) extends Query
  case class   ResponseOrder(order: List[OrderDetail])
  case class   ResponseOrderOpt(order: Option[OrderDetail])
  case class  ItemNotAvailable(reason: String)
  case class  CouponNotValid(reason: String)
}