INSERT INTO public.author(
	id, author_name, explanation)
	VALUES (1, 'test', 'test');
	INSERT INTO public.publisher(
	id, explanation, publisher_name)
	VALUES (1, 'test', 'test');
	INSERT INTO public.books(
	id, book_name, book_seriresname, book_subname, explanation, isbn_number, author_id, publisher_id)
	VALUES (1, 'test', 'test', 'test', 'test', 1, 1, 1);