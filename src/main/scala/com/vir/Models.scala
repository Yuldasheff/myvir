package com

import com.Models.WriterModels.{Id, Email, Pass, Name, Status, OrdersCompleted, TotalEarned}
import com.Models.OrderModels.{Id, Title, WordCount, NOHeadings, Status, NOImages, NOParagraphs, Comments, Plagiarism}
import com.Models.AssignmentModels.{Id, OrderId, WriterId, CompletedAt, DueDate, CreatedAt}

import java.util.{Date, UUID}

object Models {

  object WriterModels{

    type Id = UUID
    type Email = String
    type Pass = String
    type Name = String
    type Status = String
    type OrdersCompleted = UUID
    type TotalEarned = Double

  }

  object OrderModels{

    type Id = UUID
    type Title = String
    type WordCount = Int
    type NOHeadings = Int
    type NOParagraphs = Int
    type NOImages = Int
    type Status = String
    type Comments = String
    type Plagiarism = Boolean

  }

  object AssignmentModels{

    type Id = UUID
    type OrderId = UUID
    type WriterId = UUID
    type CreatedAt = Date
    type DueDate = Date
    type CompletedAt = Date

  }

  case class Writer(id: Id, email: Email, pass: Pass, name: Name, status: Status, ordersCompleted: OrdersCompleted, totalEarned: TotalEarned)
  case class Order(id: Id, title: Title, status: Status, wordCount: WordCount, NOHeadings: NOHeadings, NOImages: NOImages, NOParagraphs: NOParagraphs, comments: Comments, plagiarism: Plagiarism)
  case class Assignment(id: Id, writerId: WriterId, orderId: OrderId, createdAt: CreatedAt, dueDate: DueDate, completedAt: CompletedAt)

}
