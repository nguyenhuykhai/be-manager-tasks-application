USE [master]
GO
/****** Object:  Database [Taskify]    Script Date: 12/2/2023 6:43:44 PM ******/
CREATE DATABASE [Taskify]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'Taskify', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL16.SQLEXPRESS\MSSQL\DATA\Taskify.mdf' , SIZE = 8192KB , MAXSIZE = UNLIMITED, FILEGROWTH = 65536KB )
 LOG ON 
( NAME = N'Taskify_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL16.SQLEXPRESS\MSSQL\DATA\Taskify_log.ldf' , SIZE = 8192KB , MAXSIZE = 2048GB , FILEGROWTH = 65536KB )
 WITH CATALOG_COLLATION = DATABASE_DEFAULT, LEDGER = OFF
GO
ALTER DATABASE [Taskify] SET COMPATIBILITY_LEVEL = 160
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [Taskify].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [Taskify] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [Taskify] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [Taskify] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [Taskify] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [Taskify] SET ARITHABORT OFF 
GO
ALTER DATABASE [Taskify] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [Taskify] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [Taskify] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [Taskify] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [Taskify] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [Taskify] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [Taskify] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [Taskify] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [Taskify] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [Taskify] SET  DISABLE_BROKER 
GO
ALTER DATABASE [Taskify] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [Taskify] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [Taskify] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [Taskify] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [Taskify] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [Taskify] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [Taskify] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [Taskify] SET RECOVERY SIMPLE 
GO
ALTER DATABASE [Taskify] SET  MULTI_USER 
GO
ALTER DATABASE [Taskify] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [Taskify] SET DB_CHAINING OFF 
GO
ALTER DATABASE [Taskify] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [Taskify] SET TARGET_RECOVERY_TIME = 60 SECONDS 
GO
ALTER DATABASE [Taskify] SET DELAYED_DURABILITY = DISABLED 
GO
ALTER DATABASE [Taskify] SET ACCELERATED_DATABASE_RECOVERY = OFF  
GO
ALTER DATABASE [Taskify] SET QUERY_STORE = ON
GO
ALTER DATABASE [Taskify] SET QUERY_STORE (OPERATION_MODE = READ_WRITE, CLEANUP_POLICY = (STALE_QUERY_THRESHOLD_DAYS = 30), DATA_FLUSH_INTERVAL_SECONDS = 900, INTERVAL_LENGTH_MINUTES = 60, MAX_STORAGE_SIZE_MB = 1000, QUERY_CAPTURE_MODE = AUTO, SIZE_BASED_CLEANUP_MODE = AUTO, MAX_PLANS_PER_QUERY = 200, WAIT_STATS_CAPTURE_MODE = ON)
GO
USE [Taskify]
GO
USE [Taskify]
GO
/****** Object:  Sequence [dbo].[class_seq]    Script Date: 12/2/2023 6:43:44 PM ******/
CREATE SEQUENCE [dbo].[class_seq] 
 AS [bigint]
 START WITH 1
 INCREMENT BY 50
 MINVALUE -9223372036854775808
 MAXVALUE 9223372036854775807
 CACHE 
GO
USE [Taskify]
GO
/****** Object:  Sequence [dbo].[feature_seq]    Script Date: 12/2/2023 6:43:44 PM ******/
CREATE SEQUENCE [dbo].[feature_seq] 
 AS [bigint]
 START WITH 1
 INCREMENT BY 50
 MINVALUE -9223372036854775808
 MAXVALUE 9223372036854775807
 CACHE 
GO
USE [Taskify]
GO
/****** Object:  Sequence [dbo].[groups_seq]    Script Date: 12/2/2023 6:43:44 PM ******/
CREATE SEQUENCE [dbo].[groups_seq] 
 AS [bigint]
 START WITH 1
 INCREMENT BY 50
 MINVALUE -9223372036854775808
 MAXVALUE 9223372036854775807
 CACHE 
GO
USE [Taskify]
GO
/****** Object:  Sequence [dbo].[lecturer_seq]    Script Date: 12/2/2023 6:43:44 PM ******/
CREATE SEQUENCE [dbo].[lecturer_seq] 
 AS [bigint]
 START WITH 1
 INCREMENT BY 50
 MINVALUE -9223372036854775808
 MAXVALUE 9223372036854775807
 CACHE 
GO
USE [Taskify]
GO
/****** Object:  Sequence [dbo].[messages_seq]    Script Date: 12/2/2023 6:43:44 PM ******/
CREATE SEQUENCE [dbo].[messages_seq] 
 AS [bigint]
 START WITH 1
 INCREMENT BY 50
 MINVALUE -9223372036854775808
 MAXVALUE 9223372036854775807
 CACHE 
GO
USE [Taskify]
GO
/****** Object:  Sequence [dbo].[project_seq]    Script Date: 12/2/2023 6:43:44 PM ******/
CREATE SEQUENCE [dbo].[project_seq] 
 AS [bigint]
 START WITH 1
 INCREMENT BY 50
 MINVALUE -9223372036854775808
 MAXVALUE 9223372036854775807
 CACHE 
GO
USE [Taskify]
GO
/****** Object:  Sequence [dbo].[semester_seq]    Script Date: 12/2/2023 6:43:44 PM ******/
CREATE SEQUENCE [dbo].[semester_seq] 
 AS [bigint]
 START WITH 1
 INCREMENT BY 50
 MINVALUE -9223372036854775808
 MAXVALUE 9223372036854775807
 CACHE 
GO
USE [Taskify]
GO
/****** Object:  Sequence [dbo].[sprint_seq]    Script Date: 12/2/2023 6:43:44 PM ******/
CREATE SEQUENCE [dbo].[sprint_seq] 
 AS [bigint]
 START WITH 1
 INCREMENT BY 50
 MINVALUE -9223372036854775808
 MAXVALUE 9223372036854775807
 CACHE 
GO
USE [Taskify]
GO
/****** Object:  Sequence [dbo].[star_seq]    Script Date: 12/2/2023 6:43:44 PM ******/
CREATE SEQUENCE [dbo].[star_seq] 
 AS [bigint]
 START WITH 1
 INCREMENT BY 50
 MINVALUE -9223372036854775808
 MAXVALUE 9223372036854775807
 CACHE 
GO
USE [Taskify]
GO
/****** Object:  Sequence [dbo].[student_seq]    Script Date: 12/2/2023 6:43:44 PM ******/
CREATE SEQUENCE [dbo].[student_seq] 
 AS [bigint]
 START WITH 1
 INCREMENT BY 50
 MINVALUE -9223372036854775808
 MAXVALUE 9223372036854775807
 CACHE 
GO
USE [Taskify]
GO
/****** Object:  Sequence [dbo].[task_seq]    Script Date: 12/2/2023 6:43:44 PM ******/
CREATE SEQUENCE [dbo].[task_seq] 
 AS [bigint]
 START WITH 1
 INCREMENT BY 50
 MINVALUE -9223372036854775808
 MAXVALUE 9223372036854775807
 CACHE 
GO
USE [Taskify]
GO
/****** Object:  Sequence [dbo].[token_seq]    Script Date: 12/2/2023 6:43:44 PM ******/
CREATE SEQUENCE [dbo].[token_seq] 
 AS [bigint]
 START WITH 1
 INCREMENT BY 50
 MINVALUE -9223372036854775808
 MAXVALUE 9223372036854775807
 CACHE 
GO
/****** Object:  Table [dbo].[class]    Script Date: 12/2/2023 6:43:44 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[class](
	[class_id] [int] NOT NULL,
	[lecturer_id] [int] NULL,
	[semester_id] [int] NULL,
	[status] [bit] NULL,
	[class_name] [varchar](50) NULL,
PRIMARY KEY CLUSTERED 
(
	[class_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[feature]    Script Date: 12/2/2023 6:43:44 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[feature](
	[feature_id] [int] NOT NULL,
	[feature_name] [varchar](50) NULL,
	[description] [varchar](100) NULL,
PRIMARY KEY CLUSTERED 
(
	[feature_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[groups]    Script Date: 12/2/2023 6:43:44 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[groups](
	[class_id] [int] NULL,
	[group_id] [int] NOT NULL,
	[project_id] [int] NULL,
	[score] [real] NULL,
	[status] [bit] NULL,
	[group_name] [varchar](50) NULL,
PRIMARY KEY CLUSTERED 
(
	[group_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[lecturer]    Script Date: 12/2/2023 6:43:44 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[lecturer](
	[lecturer_id] [int] NOT NULL,
	[status] [bit] NULL,
	[email] [varchar](50) NULL,
	[lecturer_name] [varchar](50) NULL,
	[picture] [varchar](max) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[lecturer_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[messages]    Script Date: 12/2/2023 6:43:44 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[messages](
	[group_id] [int] NULL,
	[lecturer_id] [int] NULL,
	[message_id] [int] NOT NULL,
	[change_status_time] [datetime2](6) NULL,
	[request_note] [varchar](50) NULL,
	[respone_note] [varchar](50) NULL,
	[status] [varchar](50) NULL,
	[type] [varchar](50) NULL,
	[create_note] [varchar](max) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[message_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[process]    Script Date: 12/2/2023 6:43:44 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[process](
	[feature] [int] NOT NULL,
	[feature_id] [int] NULL,
	[project] [int] NOT NULL,
	[project_id] [int] NULL,
	[sprint] [int] NOT NULL,
	[sprint_id] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[feature] ASC,
	[project] ASC,
	[sprint] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[project]    Script Date: 12/2/2023 6:43:44 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[project](
	[lecturer_id] [int] NULL,
	[project_id] [int] NOT NULL,
	[status] [bit] NULL,
	[project_name] [varchar](50) NULL,
	[context] [varchar](max) NOT NULL,
	[functional_requirements] [varchar](max) NOT NULL,
	[non_functional_requirements] [varchar](max) NOT NULL,
	[problems] [varchar](max) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[project_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[semester]    Script Date: 12/2/2023 6:43:44 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[semester](
	[semester_id] [int] NOT NULL,
	[status] [bit] NULL,
	[end_date] [datetime2](6) NULL,
	[start_date] [datetime2](6) NULL,
	[semester_name] [varchar](50) NULL,
PRIMARY KEY CLUSTERED 
(
	[semester_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[sprint]    Script Date: 12/2/2023 6:43:44 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[sprint](
	[sprint_id] [int] NOT NULL,
	[status] [bit] NULL,
	[end_date] [datetime2](6) NULL,
	[start_date] [datetime2](6) NULL,
	[sprint_name] [varchar](50) NULL,
	[feedback] [varchar](100) NULL,
PRIMARY KEY CLUSTERED 
(
	[sprint_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[star]    Script Date: 12/2/2023 6:43:44 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[star](
	[good_knowledge] [real] NULL,
	[hard_working] [real] NULL,
	[sprint_id] [int] NULL,
	[star_id] [int] NOT NULL,
	[status] [bit] NULL,
	[student_id] [int] NULL,
	[team_working] [real] NULL,
	[total] [real] NULL,
	[change_status_time] [datetime2](6) NULL,
	[response_note] [varchar](100) NULL,
PRIMARY KEY CLUSTERED 
(
	[star_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[student]    Script Date: 12/2/2023 6:43:44 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[student](
	[class_id] [int] NULL,
	[group_id] [int] NULL,
	[is_leader] [bit] NULL,
	[score] [real] NULL,
	[student_id] [int] NOT NULL,
	[email] [varchar](50) NULL,
	[github] [varchar](50) NULL,
	[skills] [varchar](50) NULL,
	[student_name] [varchar](50) NULL,
	[about] [varchar](100) NULL,
	[link_facebook] [varchar](100) NULL,
	[pending] [varbinary](255) NULL,
	[status] [varchar](255) NULL,
	[password] [varchar](max) NULL,
	[picture] [varchar](max) NULL,
PRIMARY KEY CLUSTERED 
(
	[student_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[student_task]    Script Date: 12/2/2023 6:43:44 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[student_task](
	[student] [int] NOT NULL,
	[student_id] [int] NULL,
	[task] [int] NOT NULL,
	[task_id] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[student] ASC,
	[task] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[task]    Script Date: 12/2/2023 6:43:44 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[task](
	[feature_id] [int] NULL,
	[status] [bit] NULL,
	[task_id] [int] NOT NULL,
	[priority] [varchar](50) NULL,
	[task_name] [varchar](50) NULL,
	[description] [varchar](100) NULL,
	[feedback] [varchar](100) NULL,
PRIMARY KEY CLUSTERED 
(
	[task_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
INSERT [dbo].[class] ([class_id], [lecturer_id], [semester_id], [status], [class_name]) VALUES (1, NULL, NULL, 0, N'12A8')
INSERT [dbo].[class] ([class_id], [lecturer_id], [semester_id], [status], [class_name]) VALUES (2, NULL, NULL, 0, N'9.12')
GO
INSERT [dbo].[project] ([lecturer_id], [project_id], [status], [project_name], [context], [functional_requirements], [non_functional_requirements], [problems]) VALUES (NULL, 1, 1, N'Manhattan', N'The atomic boom', N'The explosion need to be 250ft tall', N'Destroy everything', N'no problem')
INSERT [dbo].[project] ([lecturer_id], [project_id], [status], [project_name], [context], [functional_requirements], [non_functional_requirements], [problems]) VALUES (NULL, 2, 1, N'Taskify', N'Help manage task', N'Able to settle things', N'high performance', N'no problem')
GO
INSERT [dbo].[student] ([class_id], [group_id], [is_leader], [score], [student_id], [email], [github], [skills], [student_name], [about], [link_facebook], [pending], [status], [password], [picture]) VALUES (1, NULL, 0, 3.2, 1, N'abc1@gmail.com', N'https://github.com/RankillerDY', NULL, NULL, N'', N'https://www.facebook.com/hau.chu.334/', NULL, NULL, N'$2a$10$DR6DXKxer/yn842/aRSDGuBdOsLbCvtUvNFUjLs385.7fuec6i9.u', NULL)
INSERT [dbo].[student] ([class_id], [group_id], [is_leader], [score], [student_id], [email], [github], [skills], [student_name], [about], [link_facebook], [pending], [status], [password], [picture]) VALUES (2, NULL, 1, 3.2, 2, N'abc2@gmail.com', N'https://github.com/RankillerDY', NULL, NULL, N'', N'https://www.facebook.com/hau.chu.334/', NULL, NULL, N'$2a$10$QMVlljf4EJ93SqABKp0jCulSrmmCHfDwy/RU4fxKpIXDYtqXG0Ub2', NULL)
GO
ALTER TABLE [dbo].[class]  WITH CHECK ADD  CONSTRAINT [FK2on56akwlwj9yp1g7ko9bl7rq] FOREIGN KEY([semester_id])
REFERENCES [dbo].[semester] ([semester_id])
GO
ALTER TABLE [dbo].[class] CHECK CONSTRAINT [FK2on56akwlwj9yp1g7ko9bl7rq]
GO
ALTER TABLE [dbo].[class]  WITH CHECK ADD  CONSTRAINT [FK7426kcgwh0nj767k9if4fmdq4] FOREIGN KEY([lecturer_id])
REFERENCES [dbo].[lecturer] ([lecturer_id])
GO
ALTER TABLE [dbo].[class] CHECK CONSTRAINT [FK7426kcgwh0nj767k9if4fmdq4]
GO
ALTER TABLE [dbo].[groups]  WITH CHECK ADD  CONSTRAINT [FK9enhtwnuc1iya534oexiv8cld] FOREIGN KEY([class_id])
REFERENCES [dbo].[class] ([class_id])
GO
ALTER TABLE [dbo].[groups] CHECK CONSTRAINT [FK9enhtwnuc1iya534oexiv8cld]
GO
ALTER TABLE [dbo].[groups]  WITH CHECK ADD  CONSTRAINT [FKnppr9twfbs3qybu6ot6ylatdl] FOREIGN KEY([project_id])
REFERENCES [dbo].[project] ([project_id])
GO
ALTER TABLE [dbo].[groups] CHECK CONSTRAINT [FKnppr9twfbs3qybu6ot6ylatdl]
GO
ALTER TABLE [dbo].[messages]  WITH CHECK ADD  CONSTRAINT [FK2cpth2c6q2d75e9ppqyc402t] FOREIGN KEY([group_id])
REFERENCES [dbo].[groups] ([group_id])
GO
ALTER TABLE [dbo].[messages] CHECK CONSTRAINT [FK2cpth2c6q2d75e9ppqyc402t]
GO
ALTER TABLE [dbo].[messages]  WITH CHECK ADD  CONSTRAINT [FK97ib10kvejk62dmfshhcq78u0] FOREIGN KEY([lecturer_id])
REFERENCES [dbo].[lecturer] ([lecturer_id])
GO
ALTER TABLE [dbo].[messages] CHECK CONSTRAINT [FK97ib10kvejk62dmfshhcq78u0]
GO
ALTER TABLE [dbo].[process]  WITH CHECK ADD  CONSTRAINT [FKapeehunit1njtnheu53dfg39p] FOREIGN KEY([project_id])
REFERENCES [dbo].[project] ([project_id])
GO
ALTER TABLE [dbo].[process] CHECK CONSTRAINT [FKapeehunit1njtnheu53dfg39p]
GO
ALTER TABLE [dbo].[process]  WITH CHECK ADD  CONSTRAINT [FKj21u5ygor07mgue8vfe4wfsf1] FOREIGN KEY([sprint_id])
REFERENCES [dbo].[sprint] ([sprint_id])
GO
ALTER TABLE [dbo].[process] CHECK CONSTRAINT [FKj21u5ygor07mgue8vfe4wfsf1]
GO
ALTER TABLE [dbo].[process]  WITH CHECK ADD  CONSTRAINT [FKq1kqbg7rcsu5ao5tac93xs8x0] FOREIGN KEY([feature_id])
REFERENCES [dbo].[feature] ([feature_id])
GO
ALTER TABLE [dbo].[process] CHECK CONSTRAINT [FKq1kqbg7rcsu5ao5tac93xs8x0]
GO
ALTER TABLE [dbo].[project]  WITH CHECK ADD  CONSTRAINT [FKsm959tfd2la9efi39dfg4w1fd] FOREIGN KEY([lecturer_id])
REFERENCES [dbo].[lecturer] ([lecturer_id])
GO
ALTER TABLE [dbo].[project] CHECK CONSTRAINT [FKsm959tfd2la9efi39dfg4w1fd]
GO
ALTER TABLE [dbo].[star]  WITH CHECK ADD  CONSTRAINT [FKcc46k3fsnpqd9nsl88xdksq0k] FOREIGN KEY([student_id])
REFERENCES [dbo].[student] ([student_id])
GO
ALTER TABLE [dbo].[star] CHECK CONSTRAINT [FKcc46k3fsnpqd9nsl88xdksq0k]
GO
ALTER TABLE [dbo].[star]  WITH CHECK ADD  CONSTRAINT [FKp10mvbibquef66yi6menpfdv7] FOREIGN KEY([sprint_id])
REFERENCES [dbo].[sprint] ([sprint_id])
GO
ALTER TABLE [dbo].[star] CHECK CONSTRAINT [FKp10mvbibquef66yi6menpfdv7]
GO
ALTER TABLE [dbo].[student]  WITH CHECK ADD  CONSTRAINT [FKdwhkib64u47wc4yo4hk0cub90] FOREIGN KEY([class_id])
REFERENCES [dbo].[class] ([class_id])
GO
ALTER TABLE [dbo].[student] CHECK CONSTRAINT [FKdwhkib64u47wc4yo4hk0cub90]
GO
ALTER TABLE [dbo].[student]  WITH CHECK ADD  CONSTRAINT [FKsflcrdigyrhbqi27vvioiw53q] FOREIGN KEY([group_id])
REFERENCES [dbo].[groups] ([group_id])
GO
ALTER TABLE [dbo].[student] CHECK CONSTRAINT [FKsflcrdigyrhbqi27vvioiw53q]
GO
ALTER TABLE [dbo].[student_task]  WITH CHECK ADD  CONSTRAINT [FKiwgfy2a2f9dt0lo5uaed91qkt] FOREIGN KEY([student_id])
REFERENCES [dbo].[student] ([student_id])
GO
ALTER TABLE [dbo].[student_task] CHECK CONSTRAINT [FKiwgfy2a2f9dt0lo5uaed91qkt]
GO
ALTER TABLE [dbo].[student_task]  WITH CHECK ADD  CONSTRAINT [FKkpecms0ad9qb4sylcdqvh7vs9] FOREIGN KEY([task_id])
REFERENCES [dbo].[task] ([task_id])
GO
ALTER TABLE [dbo].[student_task] CHECK CONSTRAINT [FKkpecms0ad9qb4sylcdqvh7vs9]
GO
ALTER TABLE [dbo].[task]  WITH CHECK ADD  CONSTRAINT [FK7ckhntubrsu7adavawg5wi13t] FOREIGN KEY([feature_id])
REFERENCES [dbo].[feature] ([feature_id])
GO
ALTER TABLE [dbo].[task] CHECK CONSTRAINT [FK7ckhntubrsu7adavawg5wi13t]
GO
USE [master]
GO
ALTER DATABASE [Taskify] SET  READ_WRITE 
GO
