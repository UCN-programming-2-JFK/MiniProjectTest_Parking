USE [master]
GO
/****** Object:  Database [Parking]    Script Date: 05-12-2022 13:15:13 ******/
CREATE DATABASE [Parking]
GO
USE [Parking]
GO
/****** Object:  Table [dbo].[Employee]    Script Date: 05-12-2022 13:15:13 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Employee](
	[Initials] [nvarchar](8) NOT NULL,
	[FirstName] [nvarchar](25) NOT NULL,
	[LastName] [nvarchar](50) NOT NULL,
	[IsManager] [bit] NOT NULL,
	[EmploymentDate] [datetime2](7) NOT NULL,
 CONSTRAINT [PK_Employee] PRIMARY KEY CLUSTERED 
(
	[Initials] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[ParkingLocation]    Script Date: 05-12-2022 13:15:13 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ParkingLocation](
	[Id] [int] IDENTITY(1,1) NOT NULL,
	[Name] [nvarchar](25) NOT NULL,
	[MonthlyFee] [int] NOT NULL,
 CONSTRAINT [PK_ParkingLocation] PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[ParkingSpot]    Script Date: 05-12-2022 13:15:13 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ParkingSpot](
	[Id] [int] IDENTITY(1,1) NOT NULL,
	[SpotNumber] [int] NOT NULL,
	[ParkingLocationId] [int] NOT NULL,
 CONSTRAINT [PK_ParkingSpot] PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[RentalAgreement]    Script Date: 05-12-2022 13:15:13 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[RentalAgreement](
	[Id] [int] IDENTITY(1,1) NOT NULL,
	[EmployeeInitials] [nvarchar](8) NOT NULL,
	[ParkingSpotId] [int] NOT NULL,
	[StartDate] [datetime2](7) NOT NULL,
	[EndDate] [datetime2](7) NOT NULL,
 CONSTRAINT [PK_RentalAgreement] PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Vehicle]    Script Date: 05-12-2022 13:15:13 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Vehicle](
	[LicensePlate] [nchar](7) NOT NULL,
	[IsElectric] [bit] NOT NULL,
	[EmployeeInitials] [nvarchar](8) NOT NULL,
	[RegistrationDate] [datetime2](7) NOT NULL,
 CONSTRAINT [PK_Car] PRIMARY KEY CLUSTERED 
(
	[LicensePlate] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
ALTER TABLE [dbo].[ParkingSpot]  WITH CHECK ADD  CONSTRAINT [FK_ParkingSpot_ParkingLocation] FOREIGN KEY([ParkingLocationId])
REFERENCES [dbo].[ParkingLocation] ([Id])
GO
ALTER TABLE [dbo].[ParkingSpot] CHECK CONSTRAINT [FK_ParkingSpot_ParkingLocation]
GO
ALTER TABLE [dbo].[RentalAgreement]  WITH CHECK ADD  CONSTRAINT [FK_RentalAgreement_Employee] FOREIGN KEY([EmployeeInitials])
REFERENCES [dbo].[Employee] ([Initials])
ON UPDATE CASCADE
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[RentalAgreement] CHECK CONSTRAINT [FK_RentalAgreement_Employee]
GO
ALTER TABLE [dbo].[RentalAgreement]  WITH CHECK ADD  CONSTRAINT [FK_RentalAgreement_ParkingSpot] FOREIGN KEY([ParkingSpotId])
REFERENCES [dbo].[ParkingSpot] ([Id])
ON UPDATE CASCADE
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[RentalAgreement] CHECK CONSTRAINT [FK_RentalAgreement_ParkingSpot]
GO
ALTER TABLE [dbo].[Vehicle]  WITH CHECK ADD  CONSTRAINT [FK_Vehicle_Employee] FOREIGN KEY([EmployeeInitials])
REFERENCES [dbo].[Employee] ([Initials])
ON UPDATE CASCADE
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[Vehicle] CHECK CONSTRAINT [FK_Vehicle_Employee]
GO
USE [master]
GO
ALTER DATABASE [Parking] SET  READ_WRITE 
GO