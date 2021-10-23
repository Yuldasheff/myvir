package com

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

}
