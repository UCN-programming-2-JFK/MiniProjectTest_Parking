USE [master]
GO
/****** Object:  Database [Parking]    Script Date: 05-12-2022 13:15:13 ******/
CREATE DATABASE [Parking]
GO
USE [Parking]
GO
/****** Object:  Table [dbo].[Employee]    Script Date: 06/12/2022 23.07.56 ******/
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
/****** Object:  Table [dbo].[ParkingLocation]    Script Date: 06/12/2022 23.07.56 ******/
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
/****** Object:  Table [dbo].[ParkingSpot]    Script Date: 06/12/2022 23.07.56 ******/
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
/****** Object:  Table [dbo].[RentalAgreement]    Script Date: 06/12/2022 23.07.56 ******/
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
/****** Object:  Table [dbo].[Vehicle]    Script Date: 06/12/2022 23.07.56 ******/
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
INSERT [dbo].[Employee] ([Initials], [FirstName], [LastName], [IsManager], [EmploymentDate]) VALUES (N'ELI', N'Elva Lauritz', N'Iversen', 0, CAST(N'2020-01-05T00:00:00.0000000' AS DateTime2))
GO
INSERT [dbo].[Employee] ([Initials], [FirstName], [LastName], [IsManager], [EmploymentDate]) VALUES (N'FAS', N'Freja Anna', N'Sander', 0, CAST(N'2012-09-12T00:00:00.0000000' AS DateTime2))
GO
INSERT [dbo].[Employee] ([Initials], [FirstName], [LastName], [IsManager], [EmploymentDate]) VALUES (N'HAA', N'Hans Agnethe', N'Albertsen', 1, CAST(N'2017-12-09T00:00:00.0000000' AS DateTime2))
GO
INSERT [dbo].[Employee] ([Initials], [FirstName], [LastName], [IsManager], [EmploymentDate]) VALUES (N'KUK', N'Kurt Ulrik', N'Kristensen', 0, CAST(N'2016-09-10T00:00:00.0000000' AS DateTime2))
GO
INSERT [dbo].[Employee] ([Initials], [FirstName], [LastName], [IsManager], [EmploymentDate]) VALUES (N'MLS', N'Malou Lis', N'Simonsen', 0, CAST(N'2005-08-12T00:00:00.0000000' AS DateTime2))
GO
INSERT [dbo].[Employee] ([Initials], [FirstName], [LastName], [IsManager], [EmploymentDate]) VALUES (N'SCL', N'Storm Christine', N'Lang', 1, CAST(N'2018-10-05T00:00:00.0000000' AS DateTime2))
GO
INSERT [dbo].[Employee] ([Initials], [FirstName], [LastName], [IsManager], [EmploymentDate]) VALUES (N'TMS', N'Tage Max', N'Sandino', 1, CAST(N'2011-07-26T00:00:00.0000000' AS DateTime2))
GO
INSERT [dbo].[Employee] ([Initials], [FirstName], [LastName], [IsManager], [EmploymentDate]) VALUES (N'VHL', N'Victoria Hildegard', N'Laursen', 0, CAST(N'2021-11-28T00:00:00.0000000' AS DateTime2))
GO
SET IDENTITY_INSERT [dbo].[ParkingLocation] ON 
GO
INSERT [dbo].[ParkingLocation] ([Id], [Name], [MonthlyFee]) VALUES (1, N'Harbor offices', 250)
GO
INSERT [dbo].[ParkingLocation] ([Id], [Name], [MonthlyFee]) VALUES (2, N'Phoenix Office Hotel', 350)
GO
INSERT [dbo].[ParkingLocation] ([Id], [Name], [MonthlyFee]) VALUES (4, N'Tech Park InnoCube', 180)
GO
SET IDENTITY_INSERT [dbo].[ParkingLocation] OFF
GO
INSERT [dbo].[Vehicle] ([LicensePlate], [IsElectric], [EmployeeInitials], [RegistrationDate]) VALUES (N'AB12345', 0, N'ELI', CAST(N'2012-08-08T00:00:00.0000000' AS DateTime2))
GO
INSERT [dbo].[Vehicle] ([LicensePlate], [IsElectric], [EmployeeInitials], [RegistrationDate]) VALUES (N'IP12134', 1, N'KUK', CAST(N'2022-12-01T00:00:00.0000000' AS DateTime2))
GO
INSERT [dbo].[Vehicle] ([LicensePlate], [IsElectric], [EmployeeInitials], [RegistrationDate]) VALUES (N'LY43990', 0, N'ELI', CAST(N'2017-09-01T00:00:00.0000000' AS DateTime2))
GO
INSERT [dbo].[Vehicle] ([LicensePlate], [IsElectric], [EmployeeInitials], [RegistrationDate]) VALUES (N'UP23990', 1, N'FAS', CAST(N'2020-03-13T00:00:00.0000000' AS DateTime2))
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
