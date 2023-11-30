USE [master]
GO
/****** Object:  Database [SWP]    Script Date: 10/3/2023 3:55:02 PM ******/
CREATE DATABASE [SWP2]
GO

USE [SWP2]
GO
/****** Object:  Table [dbo].[admin]    Script Date: 10/3/2023 3:55:02 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[admin](
	[admin_id] [char](50) NOT NULL,
	[admin_name] [varchar](50) NULL,
	[email] [varchar](50) NULL,
 CONSTRAINT [PK_Admin_1] PRIMARY KEY CLUSTERED 
(
	[admin_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[class]    Script Date: 10/3/2023 3:55:02 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[class](
	[class_id] [char](50) NOT NULL,
	[class_name] [varchar](50) NULL,
	[semester_id] [char](50) NULL,
	[lecturer_id] [char](50) NULL,
 CONSTRAINT [PK_Class] PRIMARY KEY CLUSTERED 
(
	[class_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[feature]    Script Date: 10/3/2023 3:55:02 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[feature](
	[feature_id] [char](50) NOT NULL,
	[feature_name] [varchar](50) NULL,
	[status] [bit] NULL,
	[description] [varchar](100) NULL,
 CONSTRAINT [PK_Feature] PRIMARY KEY CLUSTERED 
(
	[feature_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[group]    Script Date: 10/3/2023 3:55:02 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[group](
	[group_id] [char](50) NOT NULL,
	[group_name] [varchar](50) NULL,
	[score] [float] NULL,
	[project_id] [char](50) NULL,
	[class_id] [char](50) NOT NULL,
 CONSTRAINT [PK_group_1] PRIMARY KEY CLUSTERED 
(
	[group_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[lecturer]    Script Date: 10/3/2023 3:55:02 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[lecturer](
	[lecturer_id] [char](50) NOT NULL,
	[lecturer_name] [nvarchar](50) NULL,
	[email] [varchar](50) NULL,
	[picture] [varchar](max) NOT NULL,
	[status] [bit] NULL,
 CONSTRAINT [PK_Lecture] PRIMARY KEY CLUSTERED 
(
	[lecturer_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[messages]    Script Date: 10/3/2023 3:55:02 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[messages](
	[message_id] [char](50) NOT NULL,
	[type] [varchar](50) NULL,
	[request_note] [varchar](50) NULL,
	[create_note] [varchar](max) NULL,
	[respone_note] [varchar](50) NULL,
	[status] [varchar](50) NULL,
	[change_status_time] [datetime] NULL,
	[lecturer_id] [char](50) NULL,
	[group_id] [char](50) NULL,
 CONSTRAINT [PK_messages] PRIMARY KEY CLUSTERED 
(
	[message_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[process]    Script Date: 10/3/2023 3:55:02 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[process](
	[project_id] [char](50) NOT NULL,
	[sprint_id] [char](50) NOT NULL,
	[feature_id] [char](50) NOT NULL,
 CONSTRAINT [PK_process_1] PRIMARY KEY CLUSTERED 
(
	[project_id] ASC,
	[sprint_id] ASC,
	[feature_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[project]    Script Date: 10/3/2023 3:55:02 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[project](
	[project_id] [char](50) NOT NULL,
	[project_name] [varchar](max) NULL,
	[lecturer_id] [char](50) NULL,
	[status] [bit] NULL,
	[problems] [varchar](max) NULL,
	[context] [varchar](max) NULL,
	[functional_requirements] [varchar](max) NULL,
	[non_functional_requirements] [varchar](max) NULL,
 CONSTRAINT [PK_Project_1] PRIMARY KEY CLUSTERED 
(
	[project_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[semester]    Script Date: 10/3/2023 3:55:02 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[semester](
	[semester_id] [char](50) NOT NULL,
	[semester_name] [varchar](50) NULL,
	[start_date] [date] NULL,
	[end_date] [date] NULL,
	[status] [bit] NULL,
 CONSTRAINT [PK_Semeter] PRIMARY KEY CLUSTERED 
(
	[semester_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[sprint]    Script Date: 10/3/2023 3:55:02 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[sprint](
	[sprint_id] [char](50) NOT NULL,
	[sprint_name] [varchar](50) NULL,
	[class_id] [char](50) NULL,
	[feedback] [varchar](100) NULL,
	[status] [bit] NULL,
	[start_date] [date] NULL,
	[end_date] [date] NULL,
 CONSTRAINT [PK_Process] PRIMARY KEY CLUSTERED 
(
	[sprint_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[star]    Script Date: 10/3/2023 3:55:02 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[star](
	[student_reviewed_id] [char](50) NOT NULL,
	[sprint_id] [char](50) NOT NULL,
	[hard_working] [float] NULL,
	[good_knowledge] [float] NULL,
	[team_working] [float] NULL,
	[total] [float] NULL,
	[respone_note] [varchar](100) NULL,
	[status] [varchar](50) NULL,
	[change_status_time] [datetime] NULL,
	[student_reviewer_id] [char](50) NOT NULL,
 CONSTRAINT [PK_star2] PRIMARY KEY CLUSTERED 
(
	[student_reviewed_id] ASC,
	[sprint_id] ASC,
	[student_reviewer_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[student]    Script Date: 10/3/2023 3:55:02 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[student](
	[student_id] [char](50) NOT NULL,
	[student_name] [nvarchar](50) NULL,
	[class_id] [char](50) NULL,
	[group_id] [char](50) NULL,
	[score] [float] NULL,
	[link_facebook] [varchar](100) NULL,
	[email] [varchar](50) NULL,
	[github] [varchar](50) NULL,
	[skills] [varchar](50) NULL,
	[about] [varchar](100) NULL,
	[picture] [varchar](max) NULL,
	[status] [varchar](50) NULL,
	[is_leader] [bit] NULL,
 CONSTRAINT [PK_Student] PRIMARY KEY CLUSTERED 
(
	[student_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[student_task]    Script Date: 10/3/2023 3:55:02 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[student_task](
	[student_id] [char](50) NOT NULL,
	[task_id] [char](50) NOT NULL,
 CONSTRAINT [PK_student_task] PRIMARY KEY CLUSTERED 
(
	[student_id] ASC,
	[task_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[task]    Script Date: 10/3/2023 3:55:02 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[task](
	[task_id] [char](50) NOT NULL,
	[task_name] [varchar](50) NULL,
	[feature_id] [char](50) NULL,
	[status] [varchar](50) NULL,
	[feedback] [varchar](100) NULL,
	[prority] [varchar](50) NULL,
	[description] [varbinary](100) NULL,
	[create_date] [datetime] NULL,
	[finish_date] [datetime] NULL,
 CONSTRAINT [PK_Task] PRIMARY KEY CLUSTERED 
(
	[task_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
SET ANSI_PADDING ON
GO
/****** Object:  Index [IX_student_task]    Script Date: 10/3/2023 3:55:02 PM ******/
CREATE NONCLUSTERED INDEX [IX_student_task] ON [dbo].[student_task]
(
	[student_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, DROP_EXISTING = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
GO
SET ANSI_PADDING ON
GO
/****** Object:  Index [IX_student_task_1]    Script Date: 10/3/2023 3:55:02 PM ******/
CREATE NONCLUSTERED INDEX [IX_student_task_1] ON [dbo].[student_task]
(
	[task_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, DROP_EXISTING = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
GO
ALTER TABLE [dbo].[class]  WITH CHECK ADD  CONSTRAINT [FK_class_lecture1] FOREIGN KEY([lecturer_id])
REFERENCES [dbo].[lecturer] ([lecturer_id])
GO
ALTER TABLE [dbo].[class] CHECK CONSTRAINT [FK_class_lecture1]
GO
ALTER TABLE [dbo].[class]  WITH CHECK ADD  CONSTRAINT [FK_class_semester] FOREIGN KEY([semester_id])
REFERENCES [dbo].[semester] ([semester_id])
GO
ALTER TABLE [dbo].[class] CHECK CONSTRAINT [FK_class_semester]
GO
ALTER TABLE [dbo].[group]  WITH CHECK ADD  CONSTRAINT [FK_group_class1] FOREIGN KEY([class_id])
REFERENCES [dbo].[class] ([class_id])
GO
ALTER TABLE [dbo].[group] CHECK CONSTRAINT [FK_group_class1]
GO
ALTER TABLE [dbo].[group]  WITH CHECK ADD  CONSTRAINT [FK_group_project] FOREIGN KEY([project_id])
REFERENCES [dbo].[project] ([project_id])
GO
ALTER TABLE [dbo].[group] CHECK CONSTRAINT [FK_group_project]
GO
ALTER TABLE [dbo].[messages]  WITH CHECK ADD  CONSTRAINT [FK_messages_group] FOREIGN KEY([group_id])
REFERENCES [dbo].[group] ([group_id])
GO
ALTER TABLE [dbo].[messages] CHECK CONSTRAINT [FK_messages_group]
GO
ALTER TABLE [dbo].[messages]  WITH CHECK ADD  CONSTRAINT [FK_messages_lecture] FOREIGN KEY([lecturer_id])
REFERENCES [dbo].[lecturer] ([lecturer_id])
GO
ALTER TABLE [dbo].[messages] CHECK CONSTRAINT [FK_messages_lecture]
GO
ALTER TABLE [dbo].[messages]  WITH CHECK ADD  CONSTRAINT [FK_messages_lecture1] FOREIGN KEY([lecturer_id])
REFERENCES [dbo].[lecturer] ([lecturer_id])
GO
ALTER TABLE [dbo].[messages] CHECK CONSTRAINT [FK_messages_lecture1]
GO
ALTER TABLE [dbo].[process]  WITH CHECK ADD  CONSTRAINT [FK_process_feature] FOREIGN KEY([feature_id])
REFERENCES [dbo].[feature] ([feature_id])
GO
ALTER TABLE [dbo].[process] CHECK CONSTRAINT [FK_process_feature]
GO
ALTER TABLE [dbo].[process]  WITH CHECK ADD  CONSTRAINT [FK_process_project] FOREIGN KEY([project_id])
REFERENCES [dbo].[project] ([project_id])
GO
ALTER TABLE [dbo].[process] CHECK CONSTRAINT [FK_process_project]
GO
ALTER TABLE [dbo].[process]  WITH CHECK ADD  CONSTRAINT [FK_process_sprint] FOREIGN KEY([project_id])
REFERENCES [dbo].[sprint] ([sprint_id])
GO
ALTER TABLE [dbo].[process] CHECK CONSTRAINT [FK_process_sprint]
GO
ALTER TABLE [dbo].[project]  WITH CHECK ADD  CONSTRAINT [FK_project_lecture] FOREIGN KEY([lecturer_id])
REFERENCES [dbo].[lecturer] ([lecturer_id])
GO
ALTER TABLE [dbo].[project] CHECK CONSTRAINT [FK_project_lecture]
GO
ALTER TABLE [dbo].[sprint]  WITH CHECK ADD  CONSTRAINT [FK_sprint_class1] FOREIGN KEY([class_id])
REFERENCES [dbo].[class] ([class_id])
GO
ALTER TABLE [dbo].[sprint] CHECK CONSTRAINT [FK_sprint_class1]
GO
ALTER TABLE [dbo].[star]  WITH CHECK ADD  CONSTRAINT [FK_star_sprint] FOREIGN KEY([sprint_id])
REFERENCES [dbo].[sprint] ([sprint_id])
GO
ALTER TABLE [dbo].[star] CHECK CONSTRAINT [FK_star_sprint]
GO
ALTER TABLE [dbo].[star]  WITH CHECK ADD  CONSTRAINT [FK_star_student2] FOREIGN KEY([student_reviewed_id])
REFERENCES [dbo].[student] ([student_id])
GO
ALTER TABLE [dbo].[star] CHECK CONSTRAINT [FK_star_student2]
GO
ALTER TABLE [dbo].[star]  WITH CHECK ADD  CONSTRAINT [FK_star_student3] FOREIGN KEY([student_reviewer_id])
REFERENCES [dbo].[student] ([student_id])
GO
ALTER TABLE [dbo].[star] CHECK CONSTRAINT [FK_star_student3]
GO
ALTER TABLE [dbo].[student]  WITH CHECK ADD  CONSTRAINT [FK_student_class1] FOREIGN KEY([class_id])
REFERENCES [dbo].[class] ([class_id])
GO
ALTER TABLE [dbo].[student] CHECK CONSTRAINT [FK_student_class1]
GO
ALTER TABLE [dbo].[student]  WITH CHECK ADD  CONSTRAINT [FK_student_group] FOREIGN KEY([group_id])
REFERENCES [dbo].[group] ([group_id])
GO
ALTER TABLE [dbo].[student] CHECK CONSTRAINT [FK_student_group]
GO
ALTER TABLE [dbo].[student_task]  WITH CHECK ADD  CONSTRAINT [FK_student_task_student] FOREIGN KEY([student_id])
REFERENCES [dbo].[student] ([student_id])
GO
ALTER TABLE [dbo].[student_task] CHECK CONSTRAINT [FK_student_task_student]
GO
ALTER TABLE [dbo].[student_task]  WITH CHECK ADD  CONSTRAINT [FK_student_task_task] FOREIGN KEY([student_id])
REFERENCES [dbo].[task] ([task_id])
GO
ALTER TABLE [dbo].[student_task] CHECK CONSTRAINT [FK_student_task_task]
GO
ALTER TABLE [dbo].[task]  WITH CHECK ADD  CONSTRAINT [FK_task_feature1] FOREIGN KEY([feature_id])
REFERENCES [dbo].[feature] ([feature_id])
GO
ALTER TABLE [dbo].[task] CHECK CONSTRAINT [FK_task_feature1]
GO
USE [master]
GO
ALTER DATABASE [SWP2] SET  READ_WRITE 
GO